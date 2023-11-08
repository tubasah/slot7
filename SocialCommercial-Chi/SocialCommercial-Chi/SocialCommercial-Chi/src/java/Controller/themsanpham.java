/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author DELL
 */
@MultipartConfig
@WebServlet(name = "themsanpham", urlPatterns = {"/themsanpham"})

public class themsanpham extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet themsanpham</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet themsanpham at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("themsanpham.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Object iduser = session.getAttribute("id");
        Object danhmuc = session.getAttribute("danhmuc");
        Part imagePart = request.getPart("image");
        String product_name = request.getParameter("product_name");

        String realPath = request.getServletContext().getRealPath("/SavedImages");
        String filename = Paths.get(imagePart.getSubmittedFileName()).getFileName().toString();
        

        if (!Files.exists(Paths.get(realPath))) {
            Files.createDirectory(Paths.get(realPath));
        }
        imagePart.write(realPath+"/"+filename);
        int product_available = Integer.parseInt(request.getParameter("product_available"));
        double product_price = Double.parseDouble(request.getParameter("product_price"));
        String product_description = request.getParameter("product_description");
        ProductDAO productdao = new ProductDAO();
        productdao.themsanpham(iduser, danhmuc, product_name, "SavedImages/" + filename, product_available, product_price, filename);
        session.setAttribute("msg", "Thêm sản phẩm thành công !!!");
        response.sendRedirect("seller");
        } catch (Exception e) {
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
