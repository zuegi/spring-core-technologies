package ch.wesr.spring.core.container.annotation.javabased.litebeans.config;

import ch.wesr.spring.core.container.annotation.javabased.litebeans.componentbeans.ComponentBean1;
import ch.wesr.spring.core.container.annotation.javabased.litebeans.componentbeans.ComponentBean2;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AppComponent {

    @Bean(initMethod = "init")
    public ComponentBean1 componentBean1() {
        return new ComponentBean1();
    }

    @Bean
    public String name(ComponentBean1 componentBean1) {
        System.out.println ("name (ComponentBean1 componentBean1) method execution... hashCode: " +componentBean1.hashCode());
        System.out.println("call hasCode nochmals: " +componentBean1.hashCode());
        return "123";
    }
}
