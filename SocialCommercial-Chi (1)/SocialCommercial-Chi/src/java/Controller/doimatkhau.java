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

/**
 *
 * @author DELL
 */
@WebServlet(name = "doimatkhau", urlPatterns = {"/doimatkhau"})

public class doimatkhau extends HttpServlet {

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
            out.println("<title>Servlet doimatkhau</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet doimatkhau at " + request.getContextPath() + "</h1>");
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
        String name = request.getParameter("name");
        String passcurrent = request.getParameter("passcurrent");
        UserDAO userdao = new UserDAO();
        User user = userdao.get(name, passcurrent);
        if (user != null) {
            String pass = request.getParameter("pass");
            String pass1 = request.getParameter("pass1");
            if (pass.equals(pass1)) {
                userdao.setpassbyname(name, pass);
                request.setAttribute("msg", "Đổi mật khẩu thành công !!!");
                request.getRequestDispatcher("doimk.jsp").forward(request, response);
            }
            if (!pass.equals(pass1)) {
                request.setAttribute("msg", "Ô mật khẩu mới và nhập lại mật khẩu mới không trùng nhau, Vui lòng nhập lại !!!");
                request.getRequestDispatcher("doimk.jsp").forward(request, response);

            }
        }
        if (user == null) {

            request.setAttribute("msg", "Nhập mật khẩu hiện tại không đúng,Vui lòng nhập lại !!!");
            request.getRequestDispatcher("doimk.jsp").forward(request, response);

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
