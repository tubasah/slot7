
package Controller;

import DAO.CommentSocialDAO;
import DAO.NotificationDAO;
import DAO.UserDAO;
import Model.User;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "RemoveCommentSocial", urlPatterns = {"/RemoveCommentSocial"})
public class RemoveCommentSocial extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String NotiName = "";
        String reacter="";
        UserDAO controlUser = new UserDAO();
        for(User us:controlUser.getAllUsers()){
            if(session.getAttribute("id").toString().toLowerCase().equals(us.getId().toString().toLowerCase())){
                NotiName=us.getFullname();
                reacter=us.getImage();
                break;
            }
        }
        
        Object id  = request.getParameter("id");
        Object post_id = request.getParameter("post_id");
        Object fullName = request.getParameter("fullName");
        Object user_id = request.getParameter("user_id");
        CommentSocialDAO comment = new CommentSocialDAO();
        NotificationDAO notify = new NotificationDAO();
        comment.deleteCommentSocial(id);
        
        Date currentDate = new Date();
        notify.addNotification(user_id,
        NotiName+" đã xoá bình luận trên bài viết của bạn", currentDate,
        "PostDetail?post_id="+post_id+ "&fullName="+fullName+"&user_id="+user_id, reacter);
        
        Object ck= request.getParameter("ck");
        Object cs= request.getParameter("cs");
        if(ck != null){
            response.sendRedirect("home.jsp");
        }else if(cs != null){
            response.sendRedirect("HomeFollowing");
        }
        else{
        response.sendRedirect("PostDetail?post_id="+post_id+ "&fullName="+fullName+"&user_id="+user_id);
        }
    }

}
