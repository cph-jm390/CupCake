package dat.backend.control;

import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.entities.Cupcake;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.CupcakeFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddToCart", value = "/addtocart")
public class AddToCart extends HttpServlet {
    ConnectionPool connectionPool = new ConnectionPool();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ShoppingCart cart= (ShoppingCart) session.getAttribute("cart");

        int idTopping = Integer.parseInt(request.getParameter("topping"));
        int topPris = CupcakeFacade.getTopping(connectionPool).get(idTopping-1).getToppingPrice();

    int idBottom = Integer.parseInt(request.getParameter("bottom"));
    int botPris = CupcakeFacade.getBottom(connectionPool).get(idBottom-1).getBottomPrice();
    int quantity = Integer.parseInt(request.getParameter("quantity"));
    int totalPris= (botPris+topPris)*quantity;
    Cupcake cupcake = new Cupcake(idTopping,idBottom,quantity);
    cart.add(cupcake);
    session.setAttribute("cart", cart);
    request.setAttribute("cartsize", cart.getNumberOfCupcakes());
        request.setAttribute("totalPris", totalPris);
    request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request,response)   ;

    }
}
