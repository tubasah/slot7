/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CartDAO;
import DAO.ProductDAO;
import DAO.ThanhtoanDAO;
import Model.ItemInCart;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
@WebServlet(name = "muahang", urlPatterns = {"/muahang"})

public class muahang extends HttpServlet {

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
            out.println("<title>Servlet muahang</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet muahang at " + request.getContextPath() + "</h1>");
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
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        Object iduser = request.getParameter("iduser");
        String address = request.getParameter("address");
        String fullname = request.getParameter("fullName");
        String email = request.getParameter("email");
        String town = request.getParameter("town");
        String location = request.getParameter("address");
        String phone = request.getParameter("phone");
        String sosanphamParam = request.getParameter("sosanpham");
        ThanhtoanDAO thanhtoandao = new ThanhtoanDAO();
        ProductDAO productdao = new ProductDAO();
        Map<Object, ArrayList<ItemInCart>> productsByShop = new HashMap<>();
        int sosanpham = 0;  // Giá trị mặc định hoặc nếu không thể chuyển đổi thành số nguyên
        if (sosanphamParam != null) {
            sosanphamParam = sosanphamParam.trim();
            if (!sosanphamParam.isEmpty()) {
                try {
                    sosanpham = Integer.parseInt(sosanphamParam);
                } catch (NumberFormatException e) {
                    // Xử lý lỗi chuyển đổi nếu cần
                }
            }
        }
        String sodonParam = request.getParameter("sodon");
        int sodon = 0;  // Giá trị mặc định hoặc nếu không thể chuyển đổi thành số nguyên
        if (sodonParam != null) {
            sodonParam = sodonParam.trim();
            if (!sodonParam.isEmpty()) {
                try {
                    sodon = Integer.parseInt(sodonParam);
                } catch (NumberFormatException e) {
                    // Xử lý lỗi chuyển đổi nếu cần
                }
            }
        }
        ArrayList<ItemInCart> listsanpham = new ArrayList<>();
        CartDAO cartdao = new CartDAO();
        for (int i = 0; i < sosanpham; i++) {
//            dùng để sau này xóa khỏi cart
//            String idofitemincart = "id" + String.valueOf(i);
//Object productid, int quantity, Object sellerid, Double price, String shopname
            String shopname = "shopname" + String.valueOf(i);
            //Xóa item trong cart
            String itemid = "itemid" + String.valueOf(i);
            Object itemid1 = request.getParameter(itemid);
            cartdao.deleteItemInCart(itemid1);
            String productid = "productid" + String.valueOf(i);
            String sellerid = "sellerid" + String.valueOf(i);
            String price = "price" + String.valueOf(i);
            String quantity = "quantity" + String.valueOf(i);
            String shopname1 = request.getParameter(shopname);
            Object productid1 = request.getParameter(productid);
            Object sellerid1 = request.getParameter(sellerid);
            if (!productsByShop.containsKey(sellerid1)) {
                // Nếu cửa hàng chưa có trong danh sách, tạo một danh sách mới
                productsByShop.put(sellerid1, new ArrayList<>());
            }
            String priceParam = request.getParameter(price);
            Double price1 = 0.0; // Hoặc bất kỳ giá trị mặc định nào bạn muốn
            if (priceParam != null) {
                try {
                    price1 = Double.parseDouble(priceParam);
                } catch (NumberFormatException e) {
                    // Xử lý lỗi chuyển đổi nếu cần
                }
            }
            String quantityParam = request.getParameter(quantity);
            int quantity1 = 0; // Hoặc bất kỳ giá trị mặc định nào bạn muốn
            if (quantityParam != null) {
                try {
                    quantity1 = Integer.parseInt(quantityParam);
                } catch (NumberFormatException e) {
                    // Xử lý lỗi chuyển đổi nếu cần
                }
            }
            ItemInCart item = new ItemInCart(productid1, quantity1, sellerid1, price1, shopname1);
            ArrayList<ItemInCart> shopProducts = productsByShop.get(sellerid1);
            shopProducts.add(new ItemInCart(productid1, quantity1, sellerid1, price1, shopname1));
            listsanpham.add(item);
        }

        ArrayList<ItemInCart> listdonhang = new ArrayList<>();

        for (Map.Entry<Object, ArrayList<ItemInCart>> entry : productsByShop.entrySet()) {
            Object sellerid1 = entry.getKey();
//            Double total1 = 0.0; // Hoặc bất kỳ giá trị mặc định nào bạn muốn
//            if (totalParam != null) {
//                try {
//                    total1 = Double.parseDouble(totalParam);
//                } catch (NumberFormatException e) {
//                    // Xử lý lỗi chuyển đổi nếu cần
//                }
//            }

            ArrayList<ItemInCart> shopProducts = entry.getValue();
            if (!shopProducts.isEmpty()) {
                Object idorder = thanhtoandao.addNewOrderandGetThisOther(iduser, sellerid1, fullname, phone, town, location);
                for (ItemInCart item : shopProducts) {
                    boolean update = productdao.updatesanphamsaukhimuahang(item.getProductid(), item.getQuantity());
                    if (update == true) {
                        thanhtoandao.addNewOrderDetail(idorder, item.getProductid(), item.getQuantity(), item.getPrice());
                    }
                    if (update == false) {
                        session.setAttribute("msgcart", "Lỗi !!! Số lượng bạn muốn mua vượt quá mức mà sản phẩm có hoặc số lượng không hợp lệ");
                        response.sendRedirect("cart");
                        break;
                    }
                }
                thanhtoandao.UpdateOrdertotal();

            }
        }
        response.sendRedirect("request_result.jsp");
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
