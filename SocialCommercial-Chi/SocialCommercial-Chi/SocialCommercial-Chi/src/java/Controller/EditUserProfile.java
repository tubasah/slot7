
package Controller;

import DAO.UserDAO;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet(name = "EditUserProfile", urlPatterns = {"/EditUserProfile"})
public class EditUserProfile extends HttpServlet {
    private boolean isImageFile(String filename) {
        String[] allowedExtensions = {".jpg", ".jpeg", ".png", ".gif"};
        for (String extension : allowedExtensions) {
            if (filename.toLowerCase().endsWith(extension)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try{
            HttpSession session=request.getSession();
            Object user_id = session.getAttribute("id");
            
            String number = request.getParameter("number");
            Part imagePart = request.getPart("image");
            String fullname = request.getParameter("fullName");
            String gender = request.getParameter("gender");
            String statusnow = request.getParameter("statusNow");
            String school = request.getParameter("school");
            String favour = request.getParameter("favour");
            String bio = request.getParameter("bio");
        
            String realPath = request.getServletContext().getRealPath("/SavedImages");
            String filename = Paths.get(imagePart.getSubmittedFileName()).getFileName().toString();
            String image = realPath + "/" + filename;
        
            if(!Files.exists(Paths.get(realPath))){
                Files.createDirectory(Paths.get(realPath));
            }
            
            if (imagePart != null && imagePart.getSize() > 0) {

            if (isImageFile(image)) {
                imagePart.write(image);
                session.setAttribute("img", "SavedImages/"+filename);
                UserDAO edituser = new UserDAO();
                edituser.EditUser(number, "SavedImages/"+filename, fullname, gender, statusnow, school, favour, bio, user_id);
                response.sendRedirect(request.getContextPath() + "/UserProfileSocial");
            } else {
                response.setContentType("text/plain");
                response.sendRedirect(request.getContextPath() + "/UserProfileSocial");
            }
        } else {
            UserDAO edituser = new UserDAO();
            edituser.EditUserSubstractImage(number, fullname, gender, statusnow, school, favour, bio, user_id);
            response.sendRedirect(request.getContextPath() + "/UserProfileSocial");
        }
        
        }catch(Exception e){
            response.getWriter().write("Error");
        }
    }
}