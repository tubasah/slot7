package Controller;

import DAO.LikeSocialDAO;
import DAO.NotificationDAO;
import DAO.UserDAO;
import DAO.UserPostDAO;
import Model.LikeSocial;
import Model.Notification;
import Model.User;
import Model.UserPost;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})

public class LoginServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDAO dao = new UserDAO();
        String name = request.getParameter("username");
        String pass = request.getParameter("pass");
        String img = "";
        User user = new User();
        user = dao.getCaseSensitive(name, pass);
            
        if (user != null) {
            int role_id = 0;
            for (User cus : dao.getAllUsers()) {
                if (cus.getId().equals(user.getId())) {
                    img = cus.getImage();
                    role_id=cus.getRoleid();
                    break;
                }
            }
            
            NotificationDAO noti = new NotificationDAO();
            List<Notification> listNotificationUser = new ArrayList<>();
            
            for(Notification notify : noti.getAllNotifications()){
                if(notify.getUser_id()!=null&&
            notify.getUser_id().toString().toLowerCase().equals(user.getId().toString().toLowerCase())){
                    listNotificationUser.add(notify);
                }
            }
            Collections.sort(listNotificationUser, (notification1, notification2)
            -> notification1.getNotification_date().compareTo(notification2.getNotification_date()));

            Map<Object, Integer> likeCountMap = new HashMap<>();
            
            LikeSocialDAO likeSocial = new LikeSocialDAO();
            for(LikeSocial like : likeSocial.getLikeSocials()){
                Object post_id = like.getPost_id();
                if(likeCountMap.containsKey(post_id)){
                    likeCountMap.put(post_id, likeCountMap.get(post_id)+1);
                }else{
                    likeCountMap.put(post_id, 1);
                }
            }
            List<Map.Entry<Object, Integer>> sortLikeCounts = new ArrayList<>(likeCountMap.entrySet());
            Collections.sort(sortLikeCounts, (like1, like2) -> like2.getValue().compareTo(like1.getValue()));
            
            UserPostDAO post = new UserPostDAO();
            List<UserPost> listPostPopular = new ArrayList<>();
            for (Map.Entry<Object, Integer> entry : sortLikeCounts) {
                Object post_id = entry.getKey();
                for (UserPost usrpos : post.getUserPosts()) {
                    if (usrpos.getId().equals(post_id)) {
                        listPostPopular.add(usrpos);
                    }
                }
            }

            HttpSession session = request.getSession();
            session.setAttribute("id", user.getId());
            session.setAttribute("name", user.getName());
            session.setAttribute("role", user.getRoleid());
            session.setAttribute("img", img);
            session.setAttribute("listNotificationUser", listNotificationUser);
            session.setAttribute("listPostPopular", listPostPopular);
            if(role_id==4){
                response.sendRedirect("Shipper");
            }else{
                response.sendRedirect(request.getContextPath());
            }
            


        } else {
            HttpSession session = request.getSession();
            session.setAttribute("msg", "Tên đăng nhập hoặc mật khẩu sai.");
            response.sendRedirect("login");
        }

    }


}