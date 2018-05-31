package com.crud.tasks.service;

import com.crud.tasks.domain.Mail;
import net.bytebuddy.dynamic.ClassFileLocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SimpleMailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleMailMessage.class);
    @Autowired
    private JavaMailSender javaMailSender;

    public void send(final Mail mail) {
        LOGGER.info("Preparing the e-mail...");
        try {
            SimpleMailMessage mailMessage = createMailMessage(mail);
            LOGGER.info("Email was send.");
            javaMailSender.send(mailMessage);
        } catch (MailException e) {
            LOGGER.error("Failed to send email: ",e.getMessage(),e);
        }
    }

    private SimpleMailMessage createMailMessage(final Mail mail) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());
        mailMessage.setCc(mail.getCcTo());
        if (!(mail.getCcTo().equals(null) || mail.getCcTo().equals(""))) {
            mailMessage.setCc(mail.getCcTo());
        } else {
            mailMessage.setCc("");
        }
        return mailMessage;
    }
}
