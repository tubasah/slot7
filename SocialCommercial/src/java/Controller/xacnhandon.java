/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import DAO.ThanhtoanDAO;
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
@WebServlet(name = "xacnhandon", urlPatterns = {"/xacnhandon"})

public class xacnhandon extends HttpServlet {
   
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
            out.println("<title>Servlet xacnhandon</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet xacnhandon at " + request.getContextPath () + "</h1>");
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
        Object idorder=request.getParameter("orderid");
        String action=request.getParameter("action");
        if(action.equals("setxacnhan")){
        ThanhtoanDAO dao=new ThanhtoanDAO();
        dao.xacnhandonhang(idorder,"Cho van chuyen");
        response.sendRedirect("quanlidonhang");
        }
        if(action.equals("setdanggiao")){
        ThanhtoanDAO dao=new ThanhtoanDAO();
        dao.xacnhandonhang(idorder,"Dang giao");
        response.sendRedirect("Shipper");
        }
          if(action.equals("sethoanthanh")){
        ThanhtoanDAO dao=new ThanhtoanDAO();
        dao.xacnhandonhang(idorder,"Hoan thanh");
        response.sendRedirect("ShipperComplete");
        }
              if(action.equals("sethuy")){
        ThanhtoanDAO dao=new ThanhtoanDAO();
        dao.xacnhandonhang(idorder,"Da huy by customer");
        response.sendRedirect("xemdonhangdahuy");
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
