package ch.wesr.spring.core.container.annotation.javabased.composedconfig;

import ch.wesr.spring.core.container.annotation.javabased.composedconfig.config.AppConfigA;
import org.assertj.core.api.Assertions;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ComposedConfigRunner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfigA.class);

        List<String> beans = Arrays.stream(context.getBeanDefinitionNames())
                .filter(bean -> !bean.contains("org.springframework")
                        && !bean.contains("ch.wesr.spring.core.container.annotation.javabased.composedconfig.config.AppConfigB")
                        && !bean.contains("appConfigA"))
                .collect(Collectors.toList());
        Assertions.assertThat(beans)
                .hasSize(2)
                .containsExactly("springBeanB", "springBeanA");
    }
}
