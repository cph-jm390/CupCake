package dat.backend.control;

import dat.backend.model.entities.Cupcake;
import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.entities.User;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.CupcakeMapper;
import dat.backend.model.persistence.ShoppingcartMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Checkout", value = "/checkout")
public class Checkout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        CupcakeMapper cupcakeMapper = new CupcakeMapper();
        ShoppingcartMapper shoppingcartMapper = new ShoppingcartMapper();
        User user = (User) session.getAttribute("user");
        shoppingcartMapper.createShoppingcart(user, cart);
        cupcakeMapper.insertCupcakeToDB(cart);
        cart.clearShoppingcart();
        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }
}