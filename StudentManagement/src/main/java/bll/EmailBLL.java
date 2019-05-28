/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dto.Nguoidung;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Jossion
 */
public class EmailBLL {

    public static void main(String args[]) throws AddressException, MessagingException {
        Nguoidung nd = new Nguoidung(null, "abcghi", HelperBLL.randomPassword(), Byte.valueOf("1"), Byte.valueOf("1"), "09470165325", "ttngoc653@gmail.com");
        System.out.println(sendPasswordNew(nd));
    }

    private static boolean sendHTML(String emailWistSent, String subject, String contentHTML) {
        try {
            Properties mailServerProperties;
            Session getMailSession;
            MimeMessage mailMessage;

            // Step1: setup Mail Server
            mailServerProperties = System.getProperties();
            mailServerProperties.put("mail.smtp.port", "587");
            mailServerProperties.put("mail.smtp.auth", "true");
            mailServerProperties.put("mail.smtp.starttls.enable", "true");

            // Step2: get Mail Session
            getMailSession = Session.getDefaultInstance(mailServerProperties, null);
            mailMessage = new MimeMessage(getMailSession);

            mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailWistSent)); //Thay abc bằng địa chỉ người nhận

            // Bạn có thể chọn CC, BCC
//    generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("cc@gmail.com")); //Địa chỉ cc gmail
            mailMessage.setSubject(subject, "UTF-8");
            mailMessage.setContent(contentHTML, "text/html; charset=UTF-8");
            mailMessage.setHeader("Content-Type", "text/html; charset=UTF-8");

            // Step3: Send mail
            Transport transport = getMailSession.getTransport("smtp");

            // Thay your_gmail thành gmail của bạn, thay your_password thành mật khẩu gmail của bạn
            transport.connect("smtp.gmail.com", "coldboy6596@gmail.com", "qetuoafj;ZB.");
            transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
            transport.close();
            return true;
        } catch (MessagingException ex) { //throws AddressException, MessagingException
            Logger.getLogger(EmailBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean sendPasswordNew(Nguoidung nd) {
        String subject = "[StuMng] Email hướng dẫn phục hồi tài khoản";
        String content = (nd.getTinhTrang() == Byte.valueOf("0") ? "<p>Tài khoản <b>"+ nd.getTenTaiKhoan()+"</b> đã quên tài khoản và đã yêu cầu phục hồi lại mật khẩu.</p>" : "")
                + "<p style='color: red'>Mật khẩu mới hiện tại là: " + nd.getMatKhau() + "</p>";
        return sendHTML(nd.getEmail(), subject, content);
    }
}
