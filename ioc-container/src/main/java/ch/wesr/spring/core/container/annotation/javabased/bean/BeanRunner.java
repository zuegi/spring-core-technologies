package ch.wesr.spring.core.container.annotation.javabased.bean;

import ch.wesr.spring.core.container.annotation.javabased.bean.beans.SpringBeanImpl;
import ch.wesr.spring.core.container.annotation.javabased.bean.config.AppConfig;
import ch.wesr.spring.core.container.annotation.javabased.containerconfig.bean.SpringBean;
import org.assertj.core.api.Assertions;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BeanRunner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        List<String> beans = Arrays.stream(context.getBeanDefinitionNames())
                .filter(bean -> !bean.contains("org.springframework")
                        && !bean.contains("appConfig"))
                .collect(Collectors.toList());
        Assertions.assertThat(beans)
                .hasSize(1)
                .containsExactly("springBean");

        SpringBean springBean = (SpringBean) context.getBean("springBean");
        springBean.sayHello();
    }
}
