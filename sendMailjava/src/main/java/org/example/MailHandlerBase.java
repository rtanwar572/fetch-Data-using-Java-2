package org.example;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailHandlerBase {

    public void sendMail()
    {

        //properties

        //something like a map
        Properties sysPropertiesMap = System.getProperties();

        //System.out.println(sysPropertiesMap);

        //in this map I want to add 4 more key value pairs : mailing

        sysPropertiesMap.put("mail.smtp.host","smtp.gmail.com"); //smtp server
        sysPropertiesMap.put("mail.smtp.port","465"); //server port
        sysPropertiesMap.put("mail.smtp.ssl.enable","true"); //ssl -secure socket layer
        sysPropertiesMap.put("mail.smtp.auth","true"); //authentication - auth


        //authentication

        Authenticator mailAuthenticator = new CustomizedMailAuth();


        //session
        Session mailSession = Session.getInstance(sysPropertiesMap,mailAuthenticator);


        //build the mail
        //Mime message

        MimeMessage mailMessage = new MimeMessage(mailSession);

        try {
            mailMessage.setFrom(mailConstants.senderM);
            mailMessage.setSubject("Geekster Mailing class");
            mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress("rtanwar7303@gmail.com"));
            mailMessage.setText("Mainak is trying to teach mailing through java!!!");

            Transport.send(mailMessage);

            System.out.println("Mail sent !!!");
        }
        catch(Exception ex)
        {
            System.out.println("Some error while preparing mail body!!!!");
            System.out.println(ex.getMessage());
        }


    }
}
//
////import javax.mail.Authenticator;
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.util.Properties;
//
//public class MailHandlerBase {
//
//    public void send(){
//        Properties pr=System.getProperties(); //something like a map
//
////        System.out.println(pr);
//        //add 4 more key value pairs.... mailing
////        System.out.println("preparing ....... ");
//        pr.put("mail.smtp.host","smtp.gmail.com"); //smtp server
//        pr.put("mail.smtp.port","587"); //server port
//        pr.put("mail.smtp.ssl.enable","true"); //ssl -secure socket layer
//        pr.put("mail.smtp.auth","true"); //a
//
////        pr.put("mail.smtp.host","smtp.gmail.com"); //smtp server
////        pr.put("mail.smtp.port","465");  //server port
////        pr.put("mail.smtp.ss.enable","true"); //ssl-secure socket layer
////        pr.put("mail.smtp.auth","true"); //authentification -auth.
//
//        //Authentification
//        Authenticator authentic= new CustomizedMailAuth();
//
//        //session
//        Session mailSes=Session.getInstance(pr,authentic);
//        //
//        MimeMessage mailMessage=new MimeMessage(mailSes);
//        try{
//            mailMessage.setFrom(mailConstants.senderM);
//            mailMessage.setRecipient(Message.RecipientType.TO,new InternetAddress("rtanwar7303@gmail.com"));
////            mailMessage.setRecipients(Message.RecipientType.TO,new InternetAddress("hjjjhghghg.com"));
////            mailMessage.setRecipients(Message.RecipientType.TO ,new InternetAddress("rtanwar572@gmail.com"));
//            mailMessage.setText("hello brother have you got that message... ");
//            Transport.send(mailMessage);
//        }
//        catch (Exception ex){
//            System.out.println("something wrong is happend... ");
//            System.out.println(ex.getMessage());
//        }
//
//    }
//
////eneucsmcetxhxjiz
//}
