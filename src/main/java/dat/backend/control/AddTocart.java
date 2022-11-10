package dat.backend.control;

import dat.backend.model.entities.Order;
import dat.backend.model.entities.Orderline;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddTocart", value = "/addtocart")
public class AddTocart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Order order = (Order) session.getAttribute("order");

        int topID = Integer.parseInt(request.getParameter("top"));
        int botID = Integer.parseInt(request.getParameter("bottom"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        Orderline orderline = new Orderline(topID,botID,quantity);
        order.add(orderline);
        session.setAttribute("order", order);
        request.setAttribute("ordersize",order.getNumberOfOrderlines());



    }
}
