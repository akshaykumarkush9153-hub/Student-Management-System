import java.net.PasswordAuthentication;
import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;

class EmailService {

    private static final String FROM_EMAIL = System.getenv("EMAIL_USER");
    private static final String APP_PASSWORD = System.getenv("EMAIL_PASS");

    static void sendEmail(Student student) {

        if (FROM_EMAIL == null || APP_PASSWORD == null) {
            System.out.println("Email credentials not set in environment variables!");
            return;
        }

        System.out.println("Sending email...");

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(
            props,
            new jakarta.mail.Authenticator() {
                protected jakarta.mail.PasswordAuthentication getPasswordAuthentication() {
                    return new jakarta.mail.PasswordAuthentication(FROM_EMAIL, APP_PASSWORD);
                }
            }
        );

        String body =
            "Dear " + student.name + ",\n\n" +
            "Greetings from the Student Management System!\n\n" +

            "We are pleased to inform you that your registration in the Student Management System " +
            "has been completed successfully.\n\n" +

            "Registration Details:\n" +
            "------------------------------\n" +
            "Student Name : " + student.name + "\n" +
            "Student ID   : " + student.id + "\n" +
            "Course       : " + student.course + "\n\n" +

            "Please keep this information for your future reference. " +
            "If you have any questions or require assistance, feel free to contact the administration.\n\n" +

            "Thank you for registering with us.\n\n" +
            "We wish you all the best in your academic journey!\n\n" +

            "Best regards,\n" +
            "Academic Administration team\n" +
            "Email: support@sms.com\n" +
            "Phone: +91-XXXXXXXXXX";
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(FROM_EMAIL));
            message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse(student.email)
            );
            message.setSubject("Registration Successful");
            message.setText(body);

            Transport.send(message);
            System.out.println("Email Sent Successfully!");

        } catch (Exception e) {
            System.out.println("Email Failed!");
            e.printStackTrace();
        }
    }
}