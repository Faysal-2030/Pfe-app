package org.baeldung.registration.listener;

import java.util.UUID;

import lombok.RequiredArgsConstructor;
import org.baeldung.persistence.model.User;
import org.baeldung.registration.OnRegistrationCompleteEvent;
import org.baeldung.service.IUserService;
import org.baeldung.service.MailClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {
    private final IUserService service;

    private final MessageSource messages;

    private final JavaMailSender mailSender;
    private final MailClient mailClient;

    private final Environment env;

    // API

    @Override
    public void onApplicationEvent(final OnRegistrationCompleteEvent event) {
        this.confirmRegistration(event);
    }

    private void confirmRegistration(final OnRegistrationCompleteEvent event) {
        final User user = event.getUser();
        final String token = UUID.randomUUID().toString();
        service.createVerificationTokenForUser(user, token);

        final SimpleMailMessage email = constructEmailMessage(event, user, token);
        mailSender.send(email);
       // mailClient.prepareAndSend(email.getReplyTo(), email.getText(), email.getSubject());
    }

    //

    private final SimpleMailMessage constructEmailMessage(final OnRegistrationCompleteEvent event, final User user, final String token) {
        final String recipientAddress = user.getEmail();
        final String subject = "Registration Confirmation";
        final String confirmationUrl = event.getAppUrl() + "/registrationConfirm.html?token=" + token;
        final String message = messages.getMessage("message.regSucc", null, event.getLocale());
        final SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message + " \r\n" + confirmationUrl);
        email.setFrom(env.getProperty("support.email"));
        return email;
    }

}
