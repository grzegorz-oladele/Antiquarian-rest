package pl.antiquarian.antiquarian.mail;

import javax.mail.MessagingException;

public interface EmailExample {

    void send(String recipient, String email) throws MessagingException;
}
