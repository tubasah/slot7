package Controller;


import DAO.UserPostDAO;
import java.io.IOException;
import java.nio.file.Files;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

@MultipartConfig   
@WebServlet (name="CreatePost",urlPatterns={"/CreatePost"})

public class CreatePost extends HttpServlet {
    private boolean isImageFile(String filename) {
        // Validate if the file is an image (you can enhance this validation)
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
        try{
            HttpSession session=request.getSession();
        Object user_id = session.getAttribute("id");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        Part imagePart = request.getPart("image");
        Date post_date = new Date();
        
        String realPath = request.getServletContext().getRealPath("/SavedImages");
        String filename = Paths.get(imagePart.getSubmittedFileName()).getFileName().toString();
        String image = realPath + "/" + filename;
        
            if(!Files.exists(Paths.get(realPath))){
                Files.createDirectory(Paths.get(realPath));
            }
            if (isImageFile(image)) {
                imagePart.write(image);

                UserPostDAO userpost = new UserPostDAO();
                userpost.addUserPost(user_id, title, content, "SavedImages/"+filename, post_date);
                
                request.getRequestDispatcher("user_profile.jsp").forward(request, response);
            } else {
                // Handle invalid file type
                response.setContentType("text/plain");
                response.getWriter().write("Invalid file type. Please upload an image.");
            }
        
        }catch(Exception e){
            System.out.println(e);
        }
        
    }

    
}