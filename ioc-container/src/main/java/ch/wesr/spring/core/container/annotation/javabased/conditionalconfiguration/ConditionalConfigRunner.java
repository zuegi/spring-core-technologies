package ch.wesr.spring.core.container.annotation.javabased.conditionalconfiguration;

import ch.wesr.spring.core.container.annotation.javabased.conditionalconfiguration.beans.SpringBeanIfc;
import ch.wesr.spring.core.container.annotation.javabased.conditionalconfiguration.condition.IsSayGoodbyeCondition;
import ch.wesr.spring.core.container.annotation.javabased.conditionalconfiguration.condition.IsSayHelloCondition;
import ch.wesr.spring.core.container.annotation.javabased.conditionalconfiguration.config.GoodbyeConfig;
import ch.wesr.spring.core.container.annotation.javabased.conditionalconfiguration.config.HelloConfig;
import org.assertj.core.api.Assertions;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConditionalConfigRunner {

    public static void main(String[] args) {
        System.setProperty("sayAnything", IsSayHelloCondition.HELLO_FROM);

        AnnotationConfigApplicationContext helloContext = new AnnotationConfigApplicationContext();
        helloContext.register(HelloConfig.class, GoodbyeConfig.class);
        helloContext.refresh();

        List<String> helloBeans = Arrays.stream(helloContext.getBeanDefinitionNames())
                .filter(helloBean -> !helloBean.contains("org.springframework"))
                .collect(Collectors.toList());
        Assertions.assertThat(helloBeans)
                .hasSize(2)
                .containsExactly("helloConfig", "helloSpringBean");

        SpringBeanIfc sayHello = helloContext.getBean(SpringBeanIfc.class);
        sayHello.sayAnything();

        helloContext.close();

        // ---------------------------------------------------------

        System.setProperty("sayAnything", IsSayGoodbyeCondition.GOODBYE_FROM);

        AnnotationConfigApplicationContext goodbyeContext = new AnnotationConfigApplicationContext();
        goodbyeContext.register(HelloConfig.class, GoodbyeConfig.class);
        goodbyeContext.refresh();

        List<String> goodbyeBeans = Arrays.stream(goodbyeContext.getBeanDefinitionNames())
                .filter(goodbyeBean -> !goodbyeBean.contains("org.springframework"))
                .collect(Collectors.toList());
        Assertions.assertThat(goodbyeBeans)
                .hasSize(2)
                .containsExactly("goodbyeConfig", "goodbyeSpringBean");

        SpringBeanIfc sayGoodbye = goodbyeContext.getBean(SpringBeanIfc.class);
        sayGoodbye.sayAnything();

    }
}
