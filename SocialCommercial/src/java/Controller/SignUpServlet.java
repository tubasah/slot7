package Controller;

import DAO.UserDAO;
import Model.Sendmail;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SignUpServlet", urlPatterns = {"/signup"})

public class SignUpServlet extends HttpServlet {

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
        request.getRequestDispatcher("signup.jsp").forward(request, response);
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
        String username = request.getParameter("username");
        String pass = request.getParameter("pass");
        String pass1 = request.getParameter("pass1");
        String email = request.getParameter("email");
        HttpSession session = request.getSession();
        if (pass.equals(pass1)) {
//        PrintWriter out = response.getWriter();
//        out.print(username+" "+"Pass:"+ pass +"Pass1:"+pass1+"email:" +email);
            User user = new User(username, pass, email, 2);
            UserDAO userdao = new UserDAO();
            if (userdao.checkdup(username) == null && userdao.checkdupemail(email) == null ) {
// userdao.checkdupemail(email)==null
                request.setAttribute("username", username);
                request.setAttribute("pass", pass);
                request.setAttribute("email", email);

// Đặt thời gian tồn tại của session là 2 phút (120 giây)
                Random random = new Random();

                // Tạo chuỗi ngẫu nhiên có 8 chữ số
                StringBuilder randomNumber = new StringBuilder();
                for (int i = 0; i < 8; i++) {
                    int digit = random.nextInt(10); // Phát sinh số ngẫu nhiên từ 0 đến 9
                    randomNumber.append(digit);
                }

                session.setMaxInactiveInterval(120);
                Sendmail sendmail = new Sendmail();
                String text = "Mã OTP của bạn là : " + randomNumber;
                sendmail.send(email, "OTP XÁC THỰC ĐĂNG KÍ CỦA SOCO NETWORK", text);
// Tạo OTP và lưu vào session
                session.setAttribute("otp", randomNumber);
// Hiển thị OTP cho người dùng
                request.getRequestDispatcher("otp.jsp").forward(request, response);
//        
//        userdao.register(username, pass, email);
//         request.setAttribute("msg", "ĐĂNG KÍ THÀNH CÔNG, MỜI BẠN ĐĂNG NHẬP");
//            request.getRequestDispatcher("login.jsp").forward(request, response);
            } else if (userdao.checkdup(username) != null) {
                session.setAttribute("msg", "Tên đăng nhập đã tồn tại. Vui lòng nhập tên đăng nhập khác!");
                response.sendRedirect("signup");
            }
            else if (userdao.checkdupemail(email) != null) {
               session.setAttribute("msg", "TRÙNG EMAIL ĐÃ CÓ TRONG HỆ THỐNG!!! VUI LÒNG ĐĂNG KÍ BẰNG ĐỊA CHỈ EMAIL KHÁC");
                response.sendRedirect("signup");
            }
//        else if(userdao.checkdupemail(username)==null){
//               session.setAttribute("msg", "TRÙNG EMAIL ĐÃ CÓ TRONG HỆ THỐNG!!! VUI LÒNG ĐĂNG KÍ BẰNG ĐỊA CHỈ EMAIL KHÁC");
//            response.sendRedirect("login.jsp");
//        }

        } else {
            session.setAttribute("msg", "Mật khẩu nhập không trùng khớp. Vui lòng nhập lại!");
            session.setAttribute("usernameValue", username);
            session.setAttribute("emailValue", email);
            response.sendRedirect("signup");

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}