package dat.backend.control;

import dat.backend.model.entities.User;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.UserFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Admin", value = "/admin")
public class Admin extends HttpServlet {


    private static ConnectionPool connectionPool = new ConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        HttpSession session = request.getSession();
        List<User> list = (List<User>) UserFacade.getUsers(connectionPool);

        list.get(0).getRole();
        list.get(0).getBalance();
        list.get(0).getIdShoppinglist();


        //Admin admin = (Admin) session.getAttribute("admin");

        //List<User> list = UserFacade.getUsers(connectionPool);

        /*
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        Timestamp created = Timestamp.valueOf(request.getParameter("created"));
        int idShoppinglist = Integer.parseInt(request.getParameter("idShoppinglist"));
        int balance = Integer.parseInt(request.getParameter("balance"));
         */

        session.setAttribute("list", list);

        request.getRequestDispatcher("/admin.jsp").forward(request, response);

    }
}
