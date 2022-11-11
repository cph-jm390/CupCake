package dat.backend.control;

import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.entities.Cupcake;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddToCart", value = "/addtocart")
public class AddToCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        int idTopping = Integer.parseInt(request.getParameter("topping"));
        int idBottom = Integer.parseInt(request.getParameter("bottom"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        Cupcake cupcake = new Cupcake(idTopping, idBottom, quantity);
        cart.add(cupcake);
        session.setAttribute("cart", cart);
        request.setAttribute("cartsize", cart.getNumberOfCupcakes());

        request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);

    }
}
