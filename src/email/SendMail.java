/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package email;

import connection.Connect;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import resume_builder.Resume_Builder;

public class SendMail {

    
    static String mailTo;

    public static void sendEmailWithAttachments(String host, String port,
            final String userName, final String password, String toAddress,
            String subject, String message, String[] attachFiles)
            throws AddressException, MessagingException {
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.user", userName);
        properties.put("mail.password", password);

        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {

            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
        Session session = Session.getInstance(properties, auth);

        // creates a new e-mail message
        Message msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = {new InternetAddress(toAddress)};
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());

        // creates message part
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(message, "text/html");

        // creates multi-part
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        // adds attachments
        if (attachFiles != null && attachFiles.length > 0) {
            for (String filePath : attachFiles) {
                MimeBodyPart attachPart = new MimeBodyPart();

                try {
                    attachPart.attachFile(filePath);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                multipart.addBodyPart(attachPart);
            }
        }

        // sets the multi-part as e-mail's content
        msg.setContent(multipart);

        // sends the e-mail
        Transport.send(msg);

    }

    /**
     * Test sending e-mail with attachments
     */
    public static void mailpdf() {
        // SMTP info
        String host = "smtp.gmail.com";
        String port = "587";
        String mailFrom = "resumebuilder2015@gmail.com";
        String password = "myresumebuilder2015";

        //fetch email if of sender-----
                                                                        
      Resume_Builder.id = "122";
        Connect.getConnection();
        String query = "select email from person where id='"+Resume_Builder.id+"'"; 
        try {
            ResultSet email = Connect.st.executeQuery(query);

            if (email.next()) {
                mailTo = "" + email.getString("email") + "";
                System.out.println(mailTo);

            }
        } catch (SQLException e) {
            System.out.println(e + "email wrong in query");
        }

        
        // message info
        
        String subject = "Your Resume";
        String message = "Please find the attached copy of your resume with this mail . Thank you for using this service !";

        // attachments
        String[] attachFiles = new String[1];
        attachFiles[0] = System.getProperty("java.io.tmpdir") + "0011223344.pdf";

        try {
            sendEmailWithAttachments(host, port, mailFrom, password, mailTo,
                    subject, message, attachFiles);
            System.out.println("Email sent.");
            JOptionPane.showMessageDialog(null, "Your Resume was successfully mailed to " + mailTo +"");
            
        }
        catch(SendFailedException e )
        {
            System.out.println("wrong email ID");
        }
        catch (Exception ex) {
            System.out.println("Could not send email.");
            ex.printStackTrace();
        }
    }
}
