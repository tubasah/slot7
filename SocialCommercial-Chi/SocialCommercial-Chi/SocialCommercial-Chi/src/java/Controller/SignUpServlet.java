package Controller;

import DAO.UserDAO;
import Model.Sendmail;
import Model.User;
import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SignUpServlet", urlPatterns = {"/signup"})
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String pass = request.getParameter("pass");
        String pass1 = request.getParameter("pass1");
        String email = request.getParameter("email");
        HttpSession session = request.getSession();

        // Check if the password length is between 6 and 8 characters
        if (pass.length() >= 6 && pass.length() <= 12) {
            if (pass.equals(pass1)) {
                User user = new User(username, pass, email, 2);
                UserDAO userdao = new UserDAO();

                // Check for duplicate username and email
                if (userdao.checkdup(username) == null && userdao.checkdupemail(email) == null) {
                    // Set attributes for request
                    request.setAttribute("username", username);
                    request.setAttribute("pass", pass);
                    request.setAttribute("email", email);

                    // Generate a random 8-digit OTP
                    Random random = new Random();
                    StringBuilder randomNumber = new StringBuilder();
                    for (int i = 0; i < 8; i++) {
                        int digit = random.nextInt(10);
                        randomNumber.append(digit);
                    }

                    // Set the session timeout to 2 minutes (120 seconds)
                    session.setMaxInactiveInterval(120);

                    // Send an email with OTP
                    Sendmail sendmail = new Sendmail();
                    String text = "Mã OTP của bạn là : " + randomNumber;
                    sendmail.send(email, "OTP XÁC THỰC ĐĂNG KÍ CỦA SOCO NETWORK", text);

                    // Store the OTP in the session
                    session.setAttribute("otp", randomNumber);

                    // Forward to OTP verification page
                    request.getRequestDispatcher("otp.jsp").forward(request, response);
                } else if (userdao.checkdup(username) != null) {
                    session.setAttribute("msg", "Tên đăng nhập đã tồn tại. Vui lòng nhập tên đăng nhập khác!");
                    response.sendRedirect("signup");
                } else if (userdao.checkdupemail(email) != null) {
                    session.setAttribute("msg", "Trùng EMAIL đã có trong hệ thống. Vui lòng đăng kí bằng địa chỉ EMAIL khác.");
                    response.sendRedirect("signup");
                }
            } else {
                session.setAttribute("msg", "Mật khẩu nhập không trùng khớp. Vui lòng nhập lại!");
                session.setAttribute("usernameValue", username);
                session.setAttribute("emailValue", email);
                response.sendRedirect("signup");
            }
        } else {
            session.setAttribute("msg", "Mật khẩu phải có độ dài từ 6 đến 12 ký tự. Vui lòng nhập lại!");
            session.setAttribute("usernameValue", username);
            session.setAttribute("emailValue", email);
            response.sendRedirect("signup");
        }
    }

    @Override
    public String getServletInfo() {
        return "SignUp Servlet for user registration.";
    }
}