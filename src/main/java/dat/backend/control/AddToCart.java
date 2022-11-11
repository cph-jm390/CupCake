package dat.backend.control;

import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.entities.Cupcake;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.CupcakeFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddToCart", value = "/addtocart")
public class AddToCart extends HttpServlet {
    int totalPris;
    ConnectionPool connectionPool = new ConnectionPool();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ShoppingCart cart= (ShoppingCart) session.getAttribute("cart");
       List<String> cupcakeNames = new ArrayList<>();
    int idTopping = Integer.parseInt(request.getParameter("topping"));
    int idBottom = Integer.parseInt(request.getParameter("bottom"));
    int quantity = Integer.parseInt(request.getParameter("quantity"));
    int topPris = CupcakeFacade.getTopping(connectionPool).get(idTopping-1).getToppingPrice()*quantity;
    int botPris = CupcakeFacade.getBottom(connectionPool).get(idBottom-1).getBottomPrice()*quantity;
    totalPris+=topPris+botPris;
    String toppingVar=CupcakeFacade.getTopping(connectionPool).get(idTopping-1).getToppingVar();
    String bottomVar=CupcakeFacade.getBottom(connectionPool).get(idBottom-1).getBottomVar();



    Cupcake cupcake = new Cupcake(idTopping,idBottom,quantity,toppingVar,bottomVar);
    cart.add(cupcake);
    session.setAttribute("cart", cart);
        session.setAttribute("cupcakeNames", cupcakeNames);
    request.setAttribute("cartsize", cart.getNumberOfCupcakes());
        request.setAttribute("totalPris", totalPris);
    request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request,response)   ;

        request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);

    }
}
