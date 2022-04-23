package ch.wesr.spring.core.container.annotation.additional.custom.events.synchron;

import ch.wesr.spring.core.container.annotation.additional.custom.events.synchron.service.EmailService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmailServiceRunner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EmailConfig.class);

        EmailService emailService = context.getBean(EmailService.class);
        emailService.sendEmail("known.hacker@example.org", "Das ist ein Inhalt für Hacker Peter");
        emailService.sendEmail("known.spammer@example.org", "Das ist ein Inhalt für Spammer Paul");
        emailService.sendEmail("mary@example.org", "Das ist ein Inhalt für Mary");
        emailService.sendEmail("mary@xeample.org", "Das ist ein Inhalt für Mary, aber eine einem kleinen Verschreiber in der Domain Adresse");
        emailService.sendEmail("paula@example.org", "Das ist ein Inhalt für Paula");
    }
}
