package pl.antiquarian.antiquarian.mail;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailExample {

    private final JavaMailSender mailSender;


    @Override
//    @Async
    public void send(String recipient, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("Antiquarian");
        message.setTo(recipient);
        message.setSubject("Antykwariat");
        message.setText(text);
        mailSender.send(message);
    }

    public String createMessage(String name) {
        return "Witaj " + name + ", właśnie założyłeś konto w aplikacji Antykwariat";
    }
}
