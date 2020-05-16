package kasu.budgetTracker.budgetTrackerDataStore.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class RetrieveBudgetTrackerInitiateEmail {

    @Autowired
    public JavaMailSender emailSender;

    public boolean triggerEmailToClient(String to, String subject, String text) {
        sendSimpleMessage(to, subject, text);
        return true;
    }

    private void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }
}
