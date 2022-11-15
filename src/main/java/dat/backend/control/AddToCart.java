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
    // public static List<Integer> prisholder = new ArrayList<>(); //kan fjernes
    int totalPris;

    private static ConnectionPool connectionPool = new ConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");

        List<String> cupcakeNames = new ArrayList<>();
        /*
        if (cart.getNumberOfCupcakes() == 0) {
            totalPris = 0;
            prisholder.clear();
        }
         */
        //Evt smid ind i cupcakeMapper
        int idTopping = Integer.parseInt(request.getParameter("topping"));
        int idBottom = Integer.parseInt(request.getParameter("bottom"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int topPris = CupcakeFacade.getTopping(connectionPool).get(idTopping - 1).getToppingPrice() * quantity;
        int botPris = CupcakeFacade.getBottom(connectionPool).get(idBottom - 1).getBottomPrice() * quantity;
        int cupcakePris = topPris + botPris;
        // prisholder.add(cupcakePris);
        totalPris += topPris + botPris;
        String toppingVar = CupcakeFacade.getTopping(connectionPool).get(idTopping - 1).getToppingVar();
        String bottomVar = CupcakeFacade.getBottom(connectionPool).get(idBottom - 1).getBottomVar();

        //int testpris = prisholder.get(0) + cupcakePris;

        Cupcake cupcake = new Cupcake(quantity, idTopping, idBottom, toppingVar, bottomVar, cupcakePris);
        cart.add(cupcake);
        session.setAttribute("cart", cart);
        session.setAttribute("cupcakeNames", cupcakeNames);
        //session.setAttribute("testpris", testpris);

        request.setAttribute("cartsize", cart.getNumberOfCupcakes());
        session.setAttribute("totalPris", totalPris);
        //session.setAttribute("testpris", testpris);
        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }
}
