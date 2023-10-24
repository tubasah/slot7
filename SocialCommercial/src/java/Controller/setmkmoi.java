/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import DAO.UserDAO;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "setmkmoi", urlPatterns = {"/setmkmoi"})

public class setmkmoi extends HttpServlet {
   
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
            out.println("<title>Servlet setmkmoi</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet setmkmoi at " + request.getContextPath () + "</h1>");
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
         response.setContentType("text/html;charset=UTF-8");
        String pass = request.getParameter("pass");
        String pass1 = request.getParameter("pass1");
        String name = request.getParameter("name");
        HttpSession session = request.getSession();
        if (pass.equals(pass1)) {
        PrintWriter out = response.getWriter();
        out.print(name+" "+"Pass:"+ pass +"Pass1:"+pass1);
        UserDAO userdao=new UserDAO();
        userdao.setpassbyname(name, pass);
        request.setAttribute("msg", "ĐỔI MẬT KHẨU THÀNH CÔNG MỜI BẠN ĐĂNG NHẬP !!!");
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
        else{
          request.setAttribute("name", name);
          session.setAttribute("msg", "PASSWORD BẠN NHẬP KHÔNG GIỐNG NHAU !!! MỜI BẠN NHẬP LẠI");
            request.getRequestDispatcher("nhapmkmoiforget.jsp").forward(request, response);

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
