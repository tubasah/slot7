/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ProductDAO;
import DAO.UserDAO;
import Model.Doanhthu;
import Model.Product;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
public class SellerManagementController extends HttpServlet {

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

        // Kiểm tra xem người dùng đã đăng nhập hay chưa, nếu chưa, chuyển hướng đến trang đăng nhập
//    HttpSession session = request.getSession();
//    Object idseller = session.getAttribute("id");
//    if (idseller == null) {
//        response.sendRedirect("login.jsp");
//        return;
//    }
//    ProductDAO pdao = new ProductDAO();
//    List<Doanhthu> top5 = pdao.getTop5SellingProducts(idseller);
//    request.setAttribute("top5", top5);
//    request.getRequestDispatcher("seller_manager.jsp").forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Object idseller = session.getAttribute("id");
        if (idseller == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        ProductDAO pdao = new ProductDAO();
        List<Doanhthu> top5 = pdao.getTop5SellingProducts(idseller);
        int totalProduct = pdao.getTotalProduct(idseller);
        double totalRevenue = pdao.getTotalRevenue(idseller);
        int totalOrder = pdao.getTotalOrder(idseller);
        List<Integer> totalRevenueOfYear = pdao.getTotalRevenueOfYear(idseller);
        List<Integer> totalOrderOfYear = pdao.getTotalOrderOfYear(idseller);
        Gson gson = new Gson();
        String json = gson.toJson(totalRevenueOfYear);
        String json1 = gson.toJson(totalOrderOfYear);
        request.setAttribute("top5", top5);
        request.setAttribute("totalProduct", totalProduct);
        request.setAttribute("totalRevenue", totalRevenue);
        request.setAttribute("totalOrder", totalOrder);
        request.setAttribute("totalRevenueOfYear", json);
        request.setAttribute("totalOrderOfYear", json1);

        request.getRequestDispatcher("seller_manager.jsp").forward(request, response);
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
        processRequest(request, response);
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
