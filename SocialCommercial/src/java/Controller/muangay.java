/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import DAO.CartDAO;
import DAO.ProductDAO;
import Model.ItemInCart;
import Model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;


/**
 *
 * @author DELL
 */
@WebServlet(name = "muangay", urlPatterns = {"/muangay"})

public class muangay extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<title>Servlet muangay</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet muangay at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        boolean check = false;
        Object productid = request.getParameter("productid");
        ProductDAO productdao=new ProductDAO();
        int avai=productdao.getquantityProductsbyID(productid);
        int quantity = 1;
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

        if (check == false) {
  ArrayList<ItemInCart> listthanhtoan = new ArrayList<>();
       Product product= productdao.getProductsbyID(productid);

                String productname=product.getProductName();
                String productimg=product.getProductImage();
                double productprice=product.getProductPrice();
                Product product1=productdao.getOneSellerAndShopByid(productid);
                Object sellerid=product1.getSellerid();
                String shopname=product1.getShopname();
                 ItemInCart item=new ItemInCart(productid,sellerid, productname, productimg, productprice,shopname);

        request.setAttribute("item", item);
        request.getRequestDispatcher("muangay.jsp").forward(request, response);
        
    }
    }
     

    /** 
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
