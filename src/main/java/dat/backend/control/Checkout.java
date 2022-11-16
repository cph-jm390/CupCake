package dat.backend.control;

import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.entities.User;
import dat.backend.model.persistence.CupcakeMapper;
import dat.backend.model.persistence.ShoppingcartMapper;
import dat.backend.model.persistence.UserMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
        UserMapper userMapper = new UserMapper();
        int totalPris = (Integer) session.getAttribute("totalPris");
        User user = (User) session.getAttribute("user");
        userMapper.payOrder(user,totalPris);
        shoppingcartMapper.createShoppingcart(user, cart);
        cupcakeMapper.insertCupcakeToDB(cart);
        totalPris=0;
        session.setAttribute("totalPris",totalPris);
        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }
}