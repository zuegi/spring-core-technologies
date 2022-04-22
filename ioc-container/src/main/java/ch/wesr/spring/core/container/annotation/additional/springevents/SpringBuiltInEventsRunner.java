package ch.wesr.spring.core.container.annotation.additional.springevents;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringBuiltInEventsRunner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.start();
        context.stop();
        context.close();
    }

}
