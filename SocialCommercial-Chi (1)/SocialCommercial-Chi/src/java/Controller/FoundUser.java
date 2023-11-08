
package Controller;

import DAO.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "FoundUser", urlPatterns = {"/FoundUser"})
public class FoundUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user_found = request.getParameter("usersearch");
        
        UserDAO manageUser = new UserDAO();
        
        request.setAttribute("listUserFound", manageUser.searchUserByName(user_found));
        request.getRequestDispatcher("found_user.jsp").forward(request, response);

    }

}
