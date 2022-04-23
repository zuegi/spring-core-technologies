package ch.wesr.spring.core.container.annotation.additional.custom.events.synchron.listener;

import ch.wesr.spring.core.container.annotation.additional.custom.events.synchron.events.BlockedEmailEvent;
import org.springframework.context.ApplicationListener;

/**
 * Dieser Code ist nur für Demonstrationszwecke
 */
public class BlockedEmailEventListener implements ApplicationListener<BlockedEmailEvent> {

    @Override
    public void onApplicationEvent(BlockedEmailEvent event) {
        System.out.println("Diese EmailAdresse [" +event.getEmailAddress() +"] wurde blockiert und nicht versendet");
    }
}
