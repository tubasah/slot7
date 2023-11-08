
package Controller;

import DAO.UserPostDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "removePost", urlPatterns = {"/removePost"})
public class removePost extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Object post_id = request.getParameter("post_id");
        UserPostDAO manageUserPost = new UserPostDAO();
        manageUserPost.deleteUserPost(post_id);
        response.sendRedirect("UserProfileSocial");
    }

}
