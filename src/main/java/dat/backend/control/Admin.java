package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.User;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.UserFacade;
import dat.backend.model.persistence.UserMapper;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "Admin", value = "/admin")
public class Admin extends HttpServlet {

    List<User> userList = new ArrayList<>();

    private ConnectionPool connectionPool = new ConnectionPool();


    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        HttpSession session = request.getSession();

        try {
            List<User> userList = UserFacade.getUsers(connectionPool);
            session = request.getSession();
            session.setAttribute("userList", userList);

            //Admin userList = new Admin();

            //userList = (List<User>) session.getAttribute("userList");

            request.setAttribute("userList", userList);
            request.getRequestDispatcher("/admin.jsp").forward(request, response);
        } catch (Exception e) {
            Logger.getLogger("web").log(Level.SEVERE, e.getMessage());
        }

    }
}
