/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author DELL
 */
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Sendmail {
    public void send(String to, String sub, String msg) {
        // Cấu hình thông tin email
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Tạo đối tượng Session để xác thực và gửi email
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("vinhdqde170663@fpt.edu.vn", "llce xaic rnqh qxwv");
            }
        });

        try {
            // Tạo đối tượng MimeMessage
            MimeMessage message = new MimeMessage(session);
            
            // Thiết lập thông tin người gửi
            message.setFrom(new InternetAddress("vinhdqde170663@fpt.edu.vn"));
            
            // Thiết lập thông tin người nhận
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            
            // Thiết lập tiêu đề email và charset UTF-8
            message.setSubject(sub, "UTF-8");
            
            // Thiết lập nội dung email và charset UTF-8
            message.setText(msg, "UTF-8");

            // Gửi email
            Transport.send(message);

            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            System.out.println("Failed to send email. Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String to = "themy0205@gmail.com";
        String subject = "Test Email";
        String message = "This is a test email.";
        Sendmail sendmail = new Sendmail();

        sendmail.send(to, subject, message);
    }
}
