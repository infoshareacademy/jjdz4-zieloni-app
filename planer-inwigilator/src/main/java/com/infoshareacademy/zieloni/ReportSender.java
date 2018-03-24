package com.infoshareacademy.zieloni;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

@Startup
@Singleton
public class ReportSender {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Schedule(minute = "*/2", hour = "*", info = "2MinScheduler", persistent = false)

    public void sendMail() {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("wtrymigaraport", "inwigilator123");
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("wtrymigaraport@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("wtrymigaraport@gmail.com"));
            message.setSubject("Raporcik " + LocalDateTime.now().format(formatter));
            message.setText("Raport z WTRYMIGA...");

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException("Raport nie został wygenerowany", e);
        }
    }

}
