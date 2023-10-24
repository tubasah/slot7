/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.FeedbackDAO;
import DAO.ProductDAO;
import DAO.UserDAO;
import Model.Category;
import Model.Feedback;
import Model.Product;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
public class DetailControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        User u = (User) session.getAttribute("us");

        Object id = request.getParameter("pid");
        Object idaddtocart = request.getAttribute("pid");

        if (id == null) {
            ProductDAO dao = new ProductDAO();
            FeedbackDAO fed = new FeedbackDAO();
            UserDAO user = new UserDAO();

            int Total = fed.getTotalFeedback(idaddtocart);
            Object cid = dao.getProductbyCId(idaddtocart);
            Product p = dao.getProductsbyID(idaddtocart);
            List<Category> list = dao.getAllCategory();
            List<Product> related = dao.getRelatedProduct(cid);
            ArrayList<User> listAllUser = user.getAllUsers();
            List<Feedback> listfeedbackbyproduct = fed.getAllFeedbackByProductId(id);

            double avg = dao.getRatedProduct(id);

            request.setAttribute("listC", list);
            request.setAttribute("related", related);
            request.setAttribute("listfeedbackbyproduct", listfeedbackbyproduct);
            request.setAttribute("total", Total);
            request.setAttribute("avg", avg);
            request.setAttribute("detail", p);
            request.setAttribute("u", listAllUser);
            session.setAttribute("historyUrl", "list-detail?productId=" + id + "&categoryId=" + cid);
            request.getRequestDispatcher("product_detail.jsp").forward(request, response);
        }else{
            ProductDAO dao = new ProductDAO();
            FeedbackDAO fed = new FeedbackDAO();
            UserDAO user = new UserDAO();

            int Total = fed.getTotalFeedback(id);
            Object cid = dao.getProductbyCId(id);
            Product p = dao.getProductsbyID(id);
            List<Category> list = dao.getAllCategory();
            List<Product> related = dao.getRelatedProduct(cid);
            ArrayList<User> listAllUser = user.getAllUsers();
            List<Feedback> listfeedbackbyproduct = fed.getAllFeedbackByProductId(id);

            double avg = dao.getRatedProduct(id);

            request.setAttribute("listC", list);
            request.setAttribute("related", related);
            request.setAttribute("listfeedbackbyproduct", listfeedbackbyproduct);
            request.setAttribute("total", Total);
            request.setAttribute("avg", avg);
            request.setAttribute("detail", p);
            request.setAttribute("u", listAllUser);
            session.setAttribute("historyUrl", "list-detail?productId=" + id + "&categoryId=" + cid);
            request.getRequestDispatcher("product_detail.jsp").forward(request, response);
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
        doGet(request, response);
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
