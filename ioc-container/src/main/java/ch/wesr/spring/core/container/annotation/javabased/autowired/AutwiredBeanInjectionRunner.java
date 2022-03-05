package ch.wesr.spring.core.container.annotation.javabased.autowired;

import ch.wesr.spring.core.container.annotation.javabased.injection.config.SystemConfig;
import org.assertj.core.api.Assertions;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AutwiredBeanInjectionRunner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SystemConfig.class);

        List<String> beans = Arrays.stream(context.getBeanDefinitionNames())
                .filter(bean -> !bean.contains("org.springframework")
                        && !bean.contains("ch.wesr.spring.core.container.annotation.javabased.injection.config")
                        && !bean.contains("systemConfig"))
                .collect(Collectors.toList());

        Assertions.assertThat(beans)
                .hasSize(3)
                .containsExactly("springBeanService", "accountRepository", "dataSource");
    }
}
