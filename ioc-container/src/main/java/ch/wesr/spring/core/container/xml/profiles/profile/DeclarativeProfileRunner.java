package ch.wesr.spring.core.container.xml.profiles.profile;

import org.assertj.core.api.Assertions;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DeclarativeProfileRunner {

    // lass dieses Profile mit folgendem Befehl laufen
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("profiles/profile.xml");

        List<String> beans = Arrays.stream(context.getBeanDefinitionNames())
                .filter(bean -> !bean.contains("org.springframework")
                        && !bean.contains("appConfig"))
                .collect(Collectors.toList());
        Assertions.assertThat(beans)
                .hasSize(1)
                .containsExactly("springBeanA");

    }
}
