package ch.wesr.spring.core.container.annotation.additional.springevents;

import org.springframework.context.event.*;
import org.springframework.stereotype.Component;

@Component
public class EventListenerContainer {


    @EventListener
    public void handleContextRefreshEvent(ContextRefreshedEvent ctxStartEvt) {
        System.out.println("Context Refresh Event received.");
    }

    @EventListener
    public void handleContextStartEvent(ContextStartedEvent ctxStartEvt) {
        System.out.println("Context Start Event received.");
    }

    @EventListener
    public void handleContextStopEvent(ContextStoppedEvent ctxStoppedEvt) {
        System.out.println("Context Stop Event received.");
    }

    @EventListener
    public void handleContextStopEvent(ContextClosedEvent ctxClosedEvt) {
        System.out.println("Context Closed Event received.");
    }
}
