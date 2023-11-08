/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import DAO.AdminDAO;
import Model.Sendmail;
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
@WebServlet(name = "SetRole", urlPatterns = {"/SetRole"})

public class SetRole extends HttpServlet {
   
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
            out.println("<title>Servlet SetRole</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SetRole at " + request.getContextPath () + "</h1>");
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
        processRequest(request, response);
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
        Object id=request.getParameter("id");
          Object iduser=request.getParameter("iduser");
          AdminDAO dao=new AdminDAO();
           String action=request.getParameter("action");   
           String email=request.getParameter("email"); 
           Sendmail sendmail=new Sendmail();
           if(action.equals("OK")){
                  sendmail.send(email, "Chúc mừng bạn đã đăng ký bán hàng thành công trên SOCO", "Bạn đã đăng ký thành công tài khoản bán hàng. Chúc bạn có trải nghiệm tốt ở SOCO");
               dao.uprole(id, iduser);
               
           }
           if(action.equals("NO")){
                                 sendmail.send(email, "ĐĂNG KÝ BÁN HÀNG THẤT BẠI", "CHÚNG TÔI XIN LỖI VÌ TỪ CHỐI MẪU ĐƠN BÁN HÀNG CỦA BẠN. CHÚNG TÔI SẼ LIÊN HỆ BẠN SỚM ĐỂ CUNG CẤP THÊM LÝ DO");

               dao.rejectuprole(id, iduser);
           }
           response.sendRedirect("getRequestRole");
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
