package ch.wesr.spring.core.container.annotation.additional.custom.events.synchron.listener;

import ch.wesr.spring.core.container.annotation.additional.custom.events.synchron.events.BlockedEmailEvent;
import ch.wesr.spring.core.container.annotation.additional.custom.events.synchron.events.SendEmailEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceListener {

    @EventListener
    public void processBlockedEmailListEvent(BlockedEmailEvent event) {
        System.out.println("Diese EmailAdresse [" +event.getEmailAddress() +"] wurde blockiert und nicht versendet");
    }

    @EventListener
    public void processSendEmailEvent(SendEmailEvent event) {
        System.out.println("Versende Email an [" +event.getEmailAddress() +"]");
    }
}
