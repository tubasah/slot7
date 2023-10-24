/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import DAO.UserDAO;
import Model.Sendmail;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
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
@WebServlet(name = "quenmk", urlPatterns = {"/quenmk"})

public class quenmk extends HttpServlet {
   
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
            out.println("<title>Servlet quenmk</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet quenmk at " + request.getContextPath () + "</h1>");
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
     response.setContentType("text/html;charset=UTF-8");
        String email=request.getParameter("email");
        UserDAO userdao=new UserDAO();
            if(userdao.getbyemail(email)==null){
                  request.setAttribute("msg", "Email không tồn tại trong hệ thống, mời bạn nhập lại !!!");
                request.getRequestDispatcher("forget.jsp").forward(request, response);
            }
            else{
                User user=userdao.getbyemail(email);
        Random random = new Random();
        HttpSession session=request.getSession();
        // Tạo chuỗi ngẫu nhiên có 8 chữ số
        StringBuilder randomNumber = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int digit = random.nextInt(10); // Phát sinh số ngẫu nhiên từ 0 đến 9
            randomNumber.append(digit);
        }

                session.setMaxInactiveInterval(120);
            Sendmail sendmail=new Sendmail();
            String text="Mã OTP lấy lại mật khẩu của bạn là : " + randomNumber;
             sendmail.send(email, "MÃ OTP LẤY LẠI MẬT KHẨU NỀN TẢNG SOCO", text);
// Tạo OTP và lưu vào session
                session.setAttribute("otp", randomNumber);
                request.setAttribute("email", user.getEmail());
                request.setAttribute("name", user.getName());
                        
// Hiển thị OTP cho người dùng
                request.getRequestDispatcher("forgetotp.jsp").forward(request, response);
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
              response.setContentType("text/html;charset=UTF-8");

           String name = request.getParameter("name");
        String email = request.getParameter("email");
        String otpuser=request.getParameter("otpuser");
        PrintWriter out = response.getWriter();
//        out.print(otpuser);
         HttpSession session=request.getSession();
        Object otp =session.getAttribute("otp");
         UserDAO userdao=new UserDAO();
        if (otp != null && otpuser.equals(otp.toString())) {
            request.setAttribute("name", name);
            request.getRequestDispatcher("nhapmkmoiforget.jsp").forward(request, response);
} else {
            request.setAttribute("name", name);
                request.setAttribute("email", email);
            session.setAttribute("msg", "SAI MÃ OTP, VUI LÒNG NHẬP LẠI !!!");
   request.getRequestDispatcher("forgetotp.jsp").forward(request, response);
}
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
