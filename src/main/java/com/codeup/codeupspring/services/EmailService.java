package com.codeup.codeupspring.services;

import com.codeup.codeupspring.models.Post;
import com.codeup.codeupspring.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


//Create your own EmailService class and inject it into your posts controller. The service should send an email when a post is created to the user who created it using the getEmail() from the User class, so far the user could be hardcoded (Later on we will grab the user who's currently logged in the app).

@Service("mail")
public class EmailService {

    @Autowired
    public JavaMailSender emailService;

    @Value("${spring.mail.from}")
    private String from;

    public void prepareAndSend(Post post, String subject, String body) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        //msg.setTo(User.getEmail());
        msg.setTo("moore.re@gmail.com");
        msg.setSubject(subject);
        msg.setText(body);

        try {
            this.emailService.send(msg);
        } catch (MailException ex) {
            // simply log it and go on...
            System.err.println(ex.getMessage());
        }
    }
}
