/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

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
        sendHTML("","");
    }

    public static void sendHTML(String emailWistSent, String passwordNew) {
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
            mailMessage.setSubject("[StuMng] Email hướng dẫn phục hồi tài khoản");
            String emailBody = "<p style='color: red'>Mật khẩu mới hiện tại là: "+passwordNew+"</p>";
            mailMessage.setContent(emailBody, "text/html");
            
            // Step3: Send mail
            Transport transport = getMailSession.getTransport("smtp");
            
            // Thay your_gmail thành gmail của bạn, thay your_password thành mật khẩu gmail của bạn
            transport.connect("smtp.gmail.com", "coldboy6596@gmail.com", "********");
            transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
            transport.close();
        } catch (MessagingException ex) { //throws AddressException, MessagingException
            Logger.getLogger(EmailBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
