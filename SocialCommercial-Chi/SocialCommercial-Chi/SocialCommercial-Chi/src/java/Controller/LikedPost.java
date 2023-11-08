
package Controller;

import DAO.LikeSocialDAO;
import DAO.UserDAO;
import DAO.UserPostDAO;
import Model.LikeSocial;
import Model.User;
import Model.UserPost;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LikedPost", urlPatterns = {"/LikedPost"})
public class LikedPost extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object user_id = session.getAttribute("id");
        LikeSocialDAO manageLike = new LikeSocialDAO();
        List<Object> listLikedPostID = new ArrayList<>();
        
        String nameUser = "";
        UserDAO manageUser = new UserDAO();
               
        for(LikeSocial likes : manageLike.getLikeSocials()){
            if(likes.getLiker_id().toString().toLowerCase().equals(user_id.toString().toLowerCase())){
                listLikedPostID.add(likes.getPost_id());
            }
        }
        
        UserPostDAO manageUserPost = new UserPostDAO();
        List<UserPost> listLikedPostImages = new ArrayList<>();
        for(UserPost post : manageUserPost.getUserPosts()){
            for(Object post_id : listLikedPostID){
                if(post.getId().toString().toLowerCase().equals(post_id.toString().toLowerCase())){
                    listLikedPostImages.add(post);
                }
            }
        }
        request.setAttribute("AllUser", manageUser.getAllUsers());
        request.setAttribute("listLikedPostImages", listLikedPostImages);
        request.getRequestDispatcher("liked_post.jsp").forward(request, response);
    }

}
