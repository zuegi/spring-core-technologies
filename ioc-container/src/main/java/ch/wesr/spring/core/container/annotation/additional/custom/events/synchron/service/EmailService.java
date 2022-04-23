package ch.wesr.spring.core.container.annotation.additional.custom.events.synchron.service;

import ch.wesr.spring.core.container.annotation.additional.custom.events.synchron.events.BlockedEmailEvent;
import ch.wesr.spring.core.container.annotation.additional.custom.events.synchron.events.SendEmailEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {

    // Splitten des Property in eine ArrayList
    @Value("#{'${email.config.whitelist}'.split(',')}")
    private List<String> whitelist;
    @Autowired
    ApplicationEventPublisher publisher;

    public void sendEmail(String address, String content) {
        // wenn die Email Adresse nicht in der whitelist enthalten ist
        if (!whitelist.contains(address)) {
            publisher.publishEvent(new BlockedEmailEvent(this, address, content));
            return;
        }
        // die Email Adresse ist in der whitelist vorhanden
        publisher.publishEvent(new SendEmailEvent(this, address, content));
    }

}
