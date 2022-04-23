package ch.wesr.spring.core.container.annotation.additional.custom.events.synchron.service;

import ch.wesr.spring.core.container.annotation.additional.custom.events.synchron.events.BlockedEmailEvent;
import ch.wesr.spring.core.container.annotation.additional.custom.events.synchron.events.SendEmailEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Dieser Code ist nur für Demonstrationszwecke
 */
@Service
public class EmailServiceAware implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher publisher;
    private List<String> whitelist;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

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
