
package Controller;

import DAO.CommentSocialDAO;
import DAO.NotificationDAO;
import DAO.UserDAO;
import Model.User;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "CommentPost", urlPatterns = {"/CommentPost"})
public class CommentPost extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        
        String NotiName = "";
        String reacter = "";
        Object commentor_id = session.getAttribute("id");
        Object post_id = request.getParameter("post_id");
        Object fullName = request.getParameter("fullName");
        Object user_id = request.getParameter("user_id");
        String comment_user = request.getParameter("comment");
        LocalDateTime currentDateTime = LocalDateTime.now();
        Date currentDate = Date.from(currentDateTime.atZone(ZoneId.systemDefault()).toInstant());
        
        
        CommentSocialDAO comment = new CommentSocialDAO();
        NotificationDAO notify = new NotificationDAO();
        UserDAO controlUser = new UserDAO();
        
        for(User us:controlUser.getAllUsers()){
            if(commentor_id.toString().toLowerCase().equals(us.getId().toString().toLowerCase())){
                NotiName=us.getFullname();
                reacter=us.getImage();
                break;
            }
        }
        
        if(comment_user!=null){
            comment.addCommentSocial(post_id, commentor_id, comment_user, currentDate);
            Date nowDate = new Date();
            notify.addNotification(user_id,
            NotiName+" đã bình luận bài viết của bạn", nowDate,
            "PostDetail?post_id="+post_id+ "&fullName="+fullName+"&user_id="+user_id, reacter);
        }
        Object checkcomhome = request.getParameter("checkcomhome");
        Object checkcomhomefollowing = request.getParameter("checkcomhomefollowing");
        if(checkcomhome != null){
            response.sendRedirect("home.jsp");     
        }else if(checkcomhomefollowing != null){
            response.sendRedirect("HomeFollowing");  
        }
        else{
            response.sendRedirect("PostDetail?post_id="+post_id+ "&fullName="+fullName+"&user_id="+user_id);     
        }
           

    }

}
