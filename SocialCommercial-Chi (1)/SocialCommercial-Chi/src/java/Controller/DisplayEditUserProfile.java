
package Controller;

import DAO.UserDAO;
import Model.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "DisplayEditUserProfile", urlPatterns = {"/DisplayEditUserProfile"})
public class DisplayEditUserProfile extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session=request.getSession();
        
        String link_image="";
        String fullName="";
        String phone="";
        String gender="";
        String statusNow="";
        String school="";
        String favourite="";
        String bio="";
        Object id = session.getAttribute("id");

        UserDAO manageUser = new UserDAO();
        for(User user : manageUser.getAllUsers()){
            if(user.getId().toString().toLowerCase().equals(id.toString().toLowerCase())){
                link_image = user.getImage();
                fullName = user.getFullname();
                phone = user.getNumber();
                gender = user.getGender();
                statusNow = user.getStatusNow();
                school = user.getSchool();
                favourite = user.getFavour();
                bio = user.getBio();
                break;
            }
        }
        
        request.setAttribute("link_image", link_image);
        request.setAttribute("fullName", fullName);
        request.setAttribute("gender", gender);
        request.setAttribute("statusNow", statusNow);
        request.setAttribute("school", school);
        request.setAttribute("favourite", favourite);
        request.setAttribute("bio", bio);
        request.setAttribute("phone", phone);
                
        request.getRequestDispatcher("edit_userprofile.jsp").forward(request, response);

    }

}
