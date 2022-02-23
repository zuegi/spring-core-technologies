package ch.wesr.spring.core.container.annotation.componentscan.filtertype.custom;

import ch.wesr.spring.core.container.annotation.componentscan.filtertype.custom.config.AppConfig;
import org.assertj.core.api.Assertions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomFiltertypeRunner {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        List<String> beans = Arrays.stream(context.getBeanDefinitionNames())
                .filter(bean -> !bean.contains("org.springframework")
                        && !bean.contains("appConfig")
                        && !bean.contains("customMarkerInterface"))
                .collect(Collectors.toList());
        Assertions.assertThat(beans)
                .hasSize(1)
                .containsExactlyInAnyOrder("springBean");
    }
}
