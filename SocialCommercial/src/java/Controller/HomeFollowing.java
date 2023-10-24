
package Controller;

import DAO.FollowUserDAO;
import DAO.LikeSocialDAO;
import DAO.UserPostDAO;
import Model.FollowUser;
import Model.LikeSocial;
import Model.UserPost;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "HomeFollowing", urlPatterns = {"/HomeFollowing"})
public class HomeFollowing extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        Object my_id = session.getAttribute("id");
        FollowUserDAO manageFollow = new FollowUserDAO();
        UserPostDAO managePost = new UserPostDAO();
        
        List<Object> listFollowing = new ArrayList<>();
        List<UserPost> listFollowingPost = new ArrayList<>();
        
        for(FollowUser fl : manageFollow.getFollowUsers()){
            if(my_id.toString().toLowerCase().equals(fl.getFollower().toString().toLowerCase())){
                listFollowing.add(fl.getFollowing());
            }
        }
        
        for(UserPost post : managePost.getUserPosts()){
            for(Object following : listFollowing){
                if(post.getUser_id().toString().toLowerCase().equals(following.toString().toLowerCase())){
                    listFollowingPost.add(post);
                }
            }
        }
        Collections.shuffle(listFollowingPost);
//        ----------------------------------------
       
        request.setAttribute("listFollowingPost", listFollowingPost);
        request.getRequestDispatcher("home_following.jsp").forward(request, response);
    }

}
