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
@WebServlet(name = "getcontentchat", urlPatterns = {"/getcontentchat"})

public class getcontentchat extends HttpServlet {

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
            out.println("<title>Servlet getcontentchat</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet getcontentchat at " + request.getContextPath() + "</h1>");
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
        doPost(request, response);
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

        Object id1 = request.getAttribute("id1");
        ChatDAO chatdao = new ChatDAO();
        HttpSession session = request.getSession();
        Object id = session.getAttribute("id");

        if (id1 != null) {
            ArrayList<Messenger> listcontent = chatdao.gettinnhan(id, id1);
            request.setAttribute("id1", id1);
            request.setAttribute("listcontent", listcontent);
            request.getRequestDispatcher("chat").forward(request, response);

        }
        if(id1==null){
        Object nguoinhantin = request.getParameter("nguoinhantin");
        Object id2 = chatdao.getidbyname(nguoinhantin);
        ArrayList<Messenger> listcontent = chatdao.gettinnhan(id, id2);
        request.setAttribute("nguoinhan", nguoinhantin);
        request.setAttribute("id1", id2);
        request.setAttribute("listcontent", listcontent);
        request.getRequestDispatcher("chat").forward(request, response);
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
