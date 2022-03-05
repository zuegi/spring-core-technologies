package ch.wesr.spring.core.container.annotation.javabased.bean;

import ch.wesr.spring.core.container.annotation.javabased.bean.beans.SpringBeanIfc;
import ch.wesr.spring.core.container.annotation.javabased.bean.config.AppIfcConfig;
import org.assertj.core.api.Assertions;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BeanInterfaceRunner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppIfcConfig.class);
        context.refresh();

        List<String> beans = Arrays.stream(context.getBeanDefinitionNames())
                .filter(bean -> !bean.contains("org.springframework")
                        && !bean.contains("appIfcConfig"))
                .collect(Collectors.toList());
        Assertions.assertThat(beans)
                .hasSize(1)
                .containsExactly("springBean");

        SpringBeanIfc bean = context.getBean(SpringBeanIfc.class);
        bean.sayHello();
    }
}
