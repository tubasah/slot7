/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CartDAO;
import DAO.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author DELL
 */
@WebServlet(name = "addtocart", urlPatterns = {"/addtocart"})

public class addtocart extends HttpServlet {

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
            out.println("<title>Servlet addtocart</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addtocart at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        boolean check = false;
        Object id = request.getParameter("id");
        Object productid = request.getParameter("productid");
        int avai = Integer.parseInt(request.getParameter("productavai"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        
        
        
        if (quantity <= 0) {
            check = true;
            request.setAttribute("msg", "Số lượng không hợp lệ");
            request.setAttribute("pid", productid);
            request.getRequestDispatcher("detail").forward(request, response);
        }
        if (quantity > avai) {
            check = true;
            request.setAttribute("msg", "Số lượng trong kho không đủ.Vui lòng chọn số lượng nhỏ hơn");
            request.setAttribute("pid", productid);
            request.getRequestDispatcher("detail").forward(request, response);
        }

//        PrintWriter out = response.getWriter();
//        out.println(id);
//        out.println(productid);
//        out.println(quantity);
//
//
        if (check == false) {
            UserDAO userdao=new UserDAO();
            userdao.addGoiYNguoiDung(id, productid);
            CartDAO dao = new CartDAO();
            dao.addCart(id, productid, quantity, avai);
            request.setAttribute("msg", "Thêm vào giỏ hàng thành công");
            request.setAttribute("pid", productid);
            request.getRequestDispatcher("detail").forward(request, response);
        }
//        response.sendRedirect("detail");
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
