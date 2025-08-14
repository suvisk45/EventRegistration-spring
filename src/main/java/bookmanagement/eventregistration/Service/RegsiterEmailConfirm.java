package bookmanagement.eventregistration.Service;



import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class RegsiterEmailConfirm {

    @Autowired
    JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String FromUser;

    public String sendMail(String toEmail) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setSubject("Registration Successful - Welcome to Event Registration System");

        String message = """
        <html>
        <body style="font-family: Arial, sans-serif; line-height: 1.6;">
            <h2 style="color: #2E86C1;">Welcome to Event Registration System 🎉</h2>
            <p>Dear User,</p>
            <p>We are thrilled to inform you that your registration was <strong>successful</strong>.</p>
            <p>You can now log in to your account and start exploring upcoming events.</p>
            <hr>
            <p style="color: #555;">If you have any questions, feel free to reply to this email.</p>
            <p style="font-weight: bold; color: #2E86C1;">Best Regards,<br>
            Event Registration Team</p>
        </body>
        </html>
        """;

        mimeMessageHelper.setText(message, true);
        mailSender.send(mimeMessage);

        return "Registration email sent successfully.";
    }



}
