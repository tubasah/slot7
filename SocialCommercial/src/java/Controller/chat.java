/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import DAO.ChatDAO;
import Model.Messenger;
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
@WebServlet(name = "chat", urlPatterns = {"/chat"})

public class chat extends HttpServlet {

    private static ArrayList<String> getlistnguoinhantin(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
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
            out.println("<title>Servlet chat</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet chat at " + request.getContextPath () + "</h1>");
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
        doPost(request, response);
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

        
        HttpSession session=request.getSession();
       Object id= session.getAttribute("id");
       Object id1=request.getAttribute("id1");
       String nguoinhan=(String) request.getAttribute("nguoinhan");
       ChatDAO chatdao=new ChatDAO();
       ArrayList<String> listnguoinhantin=new ArrayList<>();
              ArrayList<Messenger> listcontent=(ArrayList<Messenger>) request.getAttribute("listcontent");
              if(listcontent==null){
        listnguoinhantin=chatdao.getlistnguoinhantin(id);
        request.setAttribute("listnguoinhantin",listnguoinhantin);
        request.getRequestDispatcher("chat.jsp").forward(request, response);
              }
              else{
                  listnguoinhantin=chatdao.getlistnguoinhantin(id);
                          request.setAttribute("nguoinhan", nguoinhan);

                  request.setAttribute("id1", id1);
                          request.setAttribute("listcontent", listcontent);
        request.setAttribute("listnguoinhantin",listnguoinhantin);
        request.getRequestDispatcher("chat.jsp").forward(request, response);
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
