package dat.backend.control;

import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.entities.Cupcake;
import dat.backend.model.entities.User;
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

    private static ConnectionPool connectionPool = new ConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        List<Cupcake> cupcakeList = CupcakeFacade.getCupcakes(connectionPool);
        session.setAttribute("cupcakeList", cupcakeList);

        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");
        List<String> cupcakeNames = new ArrayList<>();
        if(cart.getCupcakeList().size()==0)
        {
            totalPris=0;
        }
        int idTopping = Integer.parseInt(request.getParameter("topping"));
        int idBottom = Integer.parseInt(request.getParameter("bottom"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int topPris = CupcakeFacade.getTopping(connectionPool).get(idTopping - 1).getToppingPrice() * quantity;
        int botPris = CupcakeFacade.getBottom(connectionPool).get(idBottom - 1).getBottomPrice() * quantity;
        int cupcakePris = topPris + botPris;
        totalPris += topPris + botPris;
        String toppingVar = CupcakeFacade.getTopping(connectionPool).get(idTopping - 1).getToppingVar();
        String bottomVar = CupcakeFacade.getBottom(connectionPool).get(idBottom - 1).getBottomVar();


        Cupcake cupcake = new Cupcake(quantity, idTopping, idBottom, toppingVar, bottomVar, cupcakePris);
        cart.add(cupcake);
        session.setAttribute("cart", cart);
        session.setAttribute("cupcakeNames", cupcakeNames);

        request.setAttribute("cartsize", cart.getNumberOfCupcakes());
        session.setAttribute("totalPris", totalPris);
        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }
}
