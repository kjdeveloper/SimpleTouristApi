package jankowiak.kamil.email;

import j2html.tags.Tag;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class EmailService {

    private static final String emailAddress = "";
    private static final String emailPassword = "";
/*
    private void send(String to, String title) {
        System.out.println("SENDING EMAIL ...");
        Session session = createSession();
        MimeMessage mimeMessage = new MimeMessage(session);
        prepareEmailMessage(mimeMessage, to, title, createOrderListLikeHtml(customer, html));
        Transport.send(mimeMessage);
        System.out.println("EMAIL SENT");
    }

    private Tag createOrderListLikeHtml() {
        return ;
    }

    private void prepareEmailMessage(MimeMessage mimeMessage, String to, String title, Tag html) throws MessagingException {
        mimeMessage.setContent(html, "text/html; charset=utf-8");
        mimeMessage.setFrom(new InternetAddress(emailAddress));
        mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        mimeMessage.setSubject(title);
    }*/

    private Session createSession() {
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        return Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailAddress, emailPassword);
            }
        });
    }
/*
    public void sendEmail() {

        try {
            send("kamiljankowiak247@gmail.com", "Order", customer, orderList);
        } catch (
                MessagingException e) {
            e.printStackTrace();
        }
    }*/

}
