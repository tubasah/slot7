
package Controller;

import DAO.NotificationDAO;
import Model.Notification;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "RemoveNotificationSocial", urlPatterns = {"/RemoveNotificationSocial"})
public class RemoveNotificationSocial extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession();
        
        Notification notificationToRemove = null;
        Object notify_id = request.getParameter("notify_id");
        NotificationDAO notify = new NotificationDAO();
        notify.deleteNotification(notify_id);
        List<Notification> listNotificationUser = (List<Notification>) session.getAttribute("listNotificationUser");
        for (Notification notification : listNotificationUser) {
            if (notification.getId().toString().toLowerCase().equals(notify_id.toString().toLowerCase())) {
                notificationToRemove = notification;
                break;
            }
        }
        
        
        if (notificationToRemove != null) {
            listNotificationUser.remove(notificationToRemove);
        }
        session.setAttribute("listNotificationUser", listNotificationUser);
        response.sendRedirect("home.jsp");
    }

}
