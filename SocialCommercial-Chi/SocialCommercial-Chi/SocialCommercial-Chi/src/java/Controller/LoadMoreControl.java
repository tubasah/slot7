/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ProductDAO;
import Model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class LoadMoreControl extends HttpServlet {

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
    String amount = request.getParameter("exits");
    int iamount = Integer.parseInt(amount);       
    ProductDAO dao = new ProductDAO();
    List<Product> products = dao.getNext8Products(iamount);
    PrintWriter out = response.getWriter();
    for (Product product : products) {
        double productPrice = product.getProductPrice();
        DecimalFormat df = new DecimalFormat("#,##0 VNĐ");//dinh dang gia sp va luu trong bien formattedPrice
        String formattedPrice = df.format(productPrice);
        
        out.println("<div class=\"productt col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat\">\n"
                + "    <div class=\"featured__item\">\n"
                + "        <div class=\"featured__item__pic\" style=\"background-image: url(" + product.getProductImage() + "); background-size: cover;\">\n"
                + "            <ul class=\"featured__item__pic__hover\">\n"
                + "                <li><a href=\"#\"><i class=\"fa fa-heart\"></i></a></li>\n"
                + "                <li><a href=\"#\"><i class=\"fa fa-retweet\"></i></a></li>\n"
                + "                <li><a href=\"#\"><i class=\"fa fa-shopping-cart\"></i></a></li>\n"
                + "            </ul>\n"
                + "        </div>\n"
                + "        <div class=\"featured__item__text\">\n"
                + "            <h6><a href=\"detail?pid=" + product.getProductId() + "\">" + product.getProductName() + "</a></h6>\n"
                + "            <h5>" + formattedPrice + "</h5>\n"        
                + "        </div>\n"
                + "    </div>\n"
                + "</div>");
    }
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
        //processRequest(request, response);
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