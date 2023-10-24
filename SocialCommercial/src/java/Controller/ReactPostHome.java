
package Controller;

import DAO.LikeSocialDAO;
import DAO.NotificationDAO;
import DAO.UserDAO;
import Model.LikeSocial;
import Model.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ReactPostHome", urlPatterns = {"/ReactPostHome"})
public class ReactPostHome extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        
        NotificationDAO notify = new NotificationDAO();
        UserDAO controlUser = new UserDAO();
        
        String NotiName = "";
        Boolean check = false;
        LikeSocialDAO like = new LikeSocialDAO();
        String name = request.getParameter("name");
        Object fullName = request.getParameter("fullName");
        Object post_id = request.getParameter("post_id");
        Object liker_id = session.getAttribute("id");
        Object user_id = request.getParameter("user_id");
        String image_reacter = "";
        
        for(User us:controlUser.getAllUsers()){
            if(liker_id.toString().toLowerCase().equals(us.getId().toString().toLowerCase())){
                NotiName=us.getFullname();
                image_reacter = us.getImage();
                break;
            }
        }
        
        for(LikeSocial post  : like.getLikeSocials()){
            if(post_id.toString().toLowerCase().equals(post.getPost_id().toString().toLowerCase())
               && liker_id.toString().toLowerCase().equals(post.getLiker_id().toString().toLowerCase())){
                check = true;
                like.removeLikePost(post_id, liker_id);
                Date currentDate = new Date();
                notify.addNotification(user_id,
                NotiName+" đã bỏ yêu thích bài viết của bạn", currentDate,
                "PostDetail?post_id="+post_id+ "&fullName="+fullName+"&user_id="+user_id, image_reacter);
                break;
            }
        }
                
        if(check != true){
            like.addLikePost(post_id, liker_id);
            Date currentDate = new Date();
            notify.addNotification(user_id,
            NotiName+" đã yêu thích bài viết của bạn", currentDate,
            "PostDetail?post_id="+post_id+ "&fullName="+fullName+"&user_id="+user_id, image_reacter);

        }
        if(name != null){
            response.sendRedirect("HomeFollowing");
        }else{
            response.sendRedirect("home.jsp");
        }
        
    }

}
