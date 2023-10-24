
package Controller;

import DAO.FollowUserDAO;
import DAO.UserDAO;
import DAO.UserPostDAO;
import Model.FollowUser;
import Model.User;
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


@WebServlet(name = "UserProfileSocial", urlPatterns = {"/UserProfileSocial"})
public class UserProfileSocial extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        
        String check = null;
        String link_image="";
        String fullName="";
        String phone="";
        String gender="";
        String statusNow="";
        String school="";
        String favourite="";
        String bio="";
        int count = 0;
        int countFollowing = 0;
        int countFollower = 0;
        Object id ="";
        Object idSession = session.getAttribute("id");
        Object post_id = "";
        FollowUserDAO manageFl = new FollowUserDAO();
        try{
            Object user_id = request.getParameter("user_id");

            UserDAO manageUser = new UserDAO();
            for(User user : manageUser.getAllUsers()){
                if(user_id != null){
                    id = user_id;
                    if(user.getId().toString().toLowerCase().equals(id.toString().toLowerCase())){
                    link_image = user.getImage();
                    fullName = user.getFullname();
                    phone = user.getNumber();
                    gender = user.getGender();
                    statusNow = user.getStatusNow();
                    school = user.getSchool();
                    favourite = user.getFavour();
                    bio = user.getBio();
                    check = null;
                    break;
                    }
                }else{
                    id=idSession;
                    if(user.getId().toString().toLowerCase().equals(id.toString().toLowerCase())){
                    link_image = user.getImage();
                    fullName = user.getFullname();
                    phone = user.getNumber();
                    gender = user.getGender();
                    statusNow = user.getStatusNow();
                    school = user.getSchool();
                    favourite = user.getFavour();
                    bio = user.getBio();
                    check = "notnull";
                    break;
                    }
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
//        ----------------------------------
        String check_follow = null;
        boolean conditionFound = false;
        FollowUserDAO manageFollow = new FollowUserDAO();
        for(FollowUser fol : manageFollow.getFollowUsers()){
            if (!conditionFound && session.getAttribute("id").toString().toLowerCase().equals(fol.getFollower().toString().toLowerCase()) && 
                id.toString().toLowerCase().equals(fol.getFollowing().toString().toLowerCase())) {
                check_follow = "notnull";
                conditionFound = true; 
            }
            if(id.toString().toLowerCase().equals(fol.getFollower().toString().toLowerCase())){
                countFollowing = countFollowing+1;
            }
            if(id.toString().toLowerCase().equals(fol.getFollowing().toString().toLowerCase())){
                countFollower = countFollower+1;
            }
        }
        

        UserPostDAO managePost = new UserPostDAO();
        List<UserPost> userPosts = managePost.getUserPosts();

        List<UserPost> listUserPost = new ArrayList<>();
        for(UserPost post : userPosts){
            if(post.getUser_id().toString().toLowerCase().equals(id.toString().toLowerCase())){
                listUserPost.add(post);
                Collections.sort(listUserPost, (post1, post2) -> post2.getPost_date().compareTo(post1.getPost_date()));
                count++;
            }   
        }

        String check_listUserPost = null;
        if(!listUserPost.isEmpty()){
            check_listUserPost = "had";
        }
        
        request.setAttribute("user_id", id);
        request.setAttribute("check_follow", check_follow);
        request.setAttribute("link_image", link_image);
        request.setAttribute("check", check);
        request.setAttribute("fullName", fullName);
        request.setAttribute("count", count);
        request.setAttribute("gender", gender);
        request.setAttribute("statusNow", statusNow);
        request.setAttribute("school", school);
        request.setAttribute("favourite", favourite);
        request.setAttribute("bio", bio);
        request.setAttribute("listUserPost", listUserPost);
        request.setAttribute("check_listUserPost", check_listUserPost);
        request.setAttribute("follower", countFollower);
        request.setAttribute("following", countFollowing);
        
        
        request.getRequestDispatcher("user_profile.jsp").forward(request, response);
    }

  
}
