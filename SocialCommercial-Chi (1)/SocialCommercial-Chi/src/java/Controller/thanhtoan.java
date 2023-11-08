/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CartDAO;
import DAO.ProductDAO;
import Model.ItemInCart;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
@WebServlet(name = "thanhtoan", urlPatterns = {"/thanhtoan"})

public class thanhtoan extends HttpServlet {

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
            out.println("<title>Servlet thanhtoan</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet thanhtoan at " + request.getContextPath() + "</h1>");
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
                response.setContentType("text/html;charset=UTF-8");
HttpSession session=request.getSession();

        PrintWriter out = response.getWriter();
         boolean check=false;
        int dem = Integer.parseInt(request.getParameter("dem"));
        ArrayList<ItemInCart> list = new ArrayList<>();
        CartDAO dao = new CartDAO();
        ProductDAO productdao=new ProductDAO();
        for (int i = 1; i <= dem; i++) {
            String itemid = "item" + String.valueOf(i);
            Object itemValue = request.getParameter(itemid);

            // Kiểm tra xem giá trị của itemValue có null không trước khi thêm vào ArrayList
            if (itemValue != null) {
                String stringquantity = "itemquantity" + String.valueOf(i);
                int quantity = Integer.parseInt(request.getParameter(stringquantity));
                String productid = "productid" + String.valueOf(i);
              Object productid1= request.getParameter(productid);
                int productavai=productdao.getquantityProductsbyID(productid1);
                if(quantity>productavai||quantity<=0){
                    check=true;
                    session.setAttribute("msgcart", "Lỗi !!! Số lượng bạn muốn mua vượt quá mức mà sản phẩm có hoặc số lượng không hợp lệ");
                    response.sendRedirect("cart");
                    break;
                }
                else{
                ItemInCart item = new ItemInCart(itemValue, quantity);
                list.add(item);
                }
            }
        }
        ArrayList<ItemInCart> listthanhtoan = new ArrayList<>();
        for (ItemInCart in : list) {
            in = dao.getOneProductinCartByIdAndUpdateQuantity(in.getId(), in.getQuantity());
            listthanhtoan.add(in);
        }
        if(check==false){
        request.setAttribute("listthanhtoan", listthanhtoan);
        request.getRequestDispatcher("purchase.jsp").forward(request, response);
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