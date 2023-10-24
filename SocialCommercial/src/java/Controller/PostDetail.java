
package Controller;

import DAO.CommentSocialDAO;
import DAO.LikeSocialDAO;
import DAO.UserDAO;
import DAO.UserPostDAO;
import Model.CommentSocial;
import Model.LikeSocial;
import Model.User;
import Model.UserPost;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "PostDetail", urlPatterns = {"/PostDetail"})
public class PostDetail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        
        Object user_now = session.getAttribute("id");
        Object post_userId = "";
        Object post_id = request.getParameter("post_id"); 
        String post_title = "";  
        String user_image = "";
        String post_content = "";
        String post_image = "";
        Date post_date = null;
        Object user_id="";
        try{
            user_id = request.getParameter("user_id");
        }catch(Exception e){
            System.out.println(e);
        }
        UserDAO manageAllUsers = new UserDAO();
        for(User usr : manageAllUsers.getAllUsers()){
            if(user_id.toString().toLowerCase().equals(usr.getId().toString().toLowerCase())){
                user_image=usr.getImage();
                break;
            }
        }
        
        UserPostDAO manageUserPost = new UserPostDAO();
        
        for(UserPost post : manageUserPost.getUserPosts()){
            if(post.getId().equals(post_id)){
                post_userId = post.getUser_id();
                post_title = post.getPost_title();
                post_content = post.getPost_content();
                post_image = post.getPost_image();
                post_date = post.getPost_date();
                break;
            }
        }
        String checkToRemovePost = null;
        if(post_userId.toString().toLowerCase().equals(user_now.toString().toLowerCase())){ 
            checkToRemovePost="notnull";
        }
//        ---------------------------------------------

        ArrayList<LikeSocial> listLikes = new ArrayList<>();
        LikeSocialDAO likes = new LikeSocialDAO();

        for(LikeSocial like : likes.getLikeSocials()){
            if(like.getPost_id().toString().toLowerCase().equals(post_id.toString().toLowerCase())){
                listLikes.add(like);
            }
        }
        String check = null;
        for(LikeSocial heart : listLikes){
            if(post_id.toString().toLowerCase().equals(heart.getPost_id().toString().toLowerCase())
            && heart.getLiker_id().toString().toLowerCase().equals(session.getAttribute("id").toString().toLowerCase())){
                check = "notnull";
                break;
            }
        }
        
//        ---------------------------------------------
        
        ArrayList<CommentSocial> listComment = new ArrayList<>();
        CommentSocialDAO manageComment = new CommentSocialDAO();
        for(CommentSocial comments : manageComment.getCommentSocials()){
        if(comments.getPost_id() != null && comments.getPost_id().toString().toLowerCase().equals(post_id.toString().toLowerCase())){
            listComment.add(comments);
        }}
        listComment.sort((comment1, comment2) -> comment1.getComment_date().compareTo(comment2.getComment_date()));
        
        ArrayList<User> listAllOfUsers = manageAllUsers.getAllUsers();
        
        request.setAttribute("user_image", user_image);
        request.setAttribute("user_id", user_id);
        request.setAttribute("post_date", post_date);
        request.setAttribute("post_content", post_content);
        request.setAttribute("post_image", post_image);
        request.setAttribute("post_id", post_id);
        request.setAttribute("check", check);
        request.setAttribute("listLikesSize", listLikes.size());
        request.setAttribute("listCommentSize", listComment.size());
        request.setAttribute("checkToRemovePost", checkToRemovePost);
        request.setAttribute("listAllOfUsers", listAllOfUsers);
        request.setAttribute("listComment", listComment);
        request.setAttribute("post_userId", post_userId);
        
        request.getRequestDispatcher("post_detail.jsp").forward(request, response);
    }


}
