
package Controller;

import DAO.FollowUserDAO;
import DAO.UserDAO;
import Model.FollowUser;
import Model.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ViewFollow", urlPatterns = {"/ViewFollow"})
public class ViewFollow extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Object my_id = request.getParameter("my_id");
        
        FollowUserDAO manageFollow = new FollowUserDAO();
        UserDAO manageUser = new UserDAO();
        
        List<Object> listFollowing = new ArrayList<>();
        List<Object> listFollower = new ArrayList<>();
        List<Object> listFriend = new ArrayList<>();
        
        List<User> listFollowingDisplay = new ArrayList<>();
        List<User> listFollowerDisplay = new ArrayList<>();
        List<User> listFriendDisplay = new ArrayList<>();
        
        for(FollowUser fol : manageFollow.getFollowUsers()){
            if(my_id.toString().toLowerCase().equals(fol.getFollower().toString().toLowerCase())){
                // following
                listFollowing.add(fol.getFollowing());
            }
            if(my_id.toString().toLowerCase().equals(fol.getFollowing().toString().toLowerCase())){
                listFollower.add(fol.getFollower());
                //follower
            }
            if (my_id.toString().toLowerCase().equals(fol.getFollower().toString().toLowerCase()) && 
                listFollowing.contains(fol.getFollowing())) {
                listFriend.add(fol.getFollowing());
            }
        }

        for(User user : manageUser.getAllUsers()){
            for(Object follower : listFollower){
                if(follower.toString().toLowerCase().equals(user.getId().toString().toLowerCase())){
                    listFollowerDisplay.add(user);
                }
            }
            for(Object following : listFollowing){
                if(following.toString().toLowerCase().equals(user.getId().toString().toLowerCase())){
                    listFollowingDisplay.add(user);
                }
            }
            for(Object friend : listFriend){
                if(friend.toString().toLowerCase().equals(user.getId().toString().toLowerCase())){
                    listFriendDisplay.add(user);
                }
            }
        }
        
        
        request.setAttribute("listFollowing", listFollowingDisplay);
        request.setAttribute("listFollower", listFollowerDisplay);
        request.setAttribute("listFriend", listFriendDisplay);
        request.getRequestDispatcher("view_follow.jsp").forward(request, response);
    }

   
}
