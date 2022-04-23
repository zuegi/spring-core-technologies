package ch.wesr.spring.core.container.annotation.additional.custom.events.synchron.events;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class BlockedEmailEvent extends ApplicationEvent {
    private final String emailAddress;
    private final String content;

    public BlockedEmailEvent(Object source, String emailAddress, String content) {
        super(source);
        this.emailAddress = emailAddress;
        this.content = content;
    }

}
