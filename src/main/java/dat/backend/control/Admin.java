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
        List<User> list = UserFacade.getUsers(connectionPool);

        list.get(0).getRole();
        list.get(0).getBalance();
        list.get(0).getIdShoppinglist();

        String username = list.get(0).getUsername();


        //Admin admin = (Admin) session.getAttribute("admin");

        //List<User> list = UserFacade.getUsers(connectionPool);

        session.setAttribute("username",username);

        session.setAttribute("list", list);

        request.getRequestDispatcher("/admin.jsp").forward(request, response);

    }
}
