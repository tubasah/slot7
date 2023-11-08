/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.FeedbackDAO;
import DAO.ProductDAO;
import Model.Product;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author ADMIN
 */
@MultipartConfig
public class FeedbackController extends HttpServlet {

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("xemtrangthaidonhang.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            response.setContentType("text/html;charset=UTF-8");
            String subject = request.getParameter("subject");
            Part imagePart = request.getPart("imageurl");
            HttpSession session = request.getSession();
            Object iduser = session.getAttribute("id");
            Object product_id = request.getParameter("productId");
            int star = Integer.parseInt(request.getParameter("star"));
            String realPath = request.getServletContext().getRealPath("/SavedImages");
            String filename = Paths.get(imagePart.getSubmittedFileName()).getFileName().toString();
            String image = realPath + "/" + filename;

            if (!Files.exists(Paths.get(realPath))) {
                Files.createDirectory(Paths.get(realPath));
            }
            if (isImageFile(image)) {
                imagePart.write(image);

                ProductDAO dao = new ProductDAO();
                Product p = dao.getProductsbyID(product_id);
                FeedbackDAO fdao = new FeedbackDAO();
                fdao.insertFeedback(star, subject, "SavedImages/" + filename, true, product_id, iduser);
                boolean feedbackStatus = fdao.getFeedbackStatus(product_id, iduser);
                request.setAttribute("feedbackStatus", feedbackStatus);
                request.setAttribute("product", p);
                response.sendRedirect("detail?pid=" + product_id);
                

            } else {
                // Handle invalid file type
                response.setContentType("text/plain");
                response.getWriter().write("Invalid file type. Please upload an image.");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
