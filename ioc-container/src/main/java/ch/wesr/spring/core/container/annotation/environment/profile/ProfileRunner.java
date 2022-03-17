package ch.wesr.spring.core.container.annotation.environment.profile;

import ch.wesr.spring.core.container.annotation.environment.profile.beans.SpringBean;
import ch.wesr.spring.core.container.annotation.environment.profile.config.AppConfig;
import org.assertj.core.api.Assertions;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProfileRunner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("aprofile");
        context.register(AppConfig.class);
        context.refresh();

        List<String> beans = Arrays.stream(context.getBeanDefinitionNames())
                .filter(bean -> !bean.contains("org.springframework")
                        && !bean.contains("appConfig"))
                .collect(Collectors.toList());
        Assertions.assertThat(beans)
                .hasSize(2)
                .containsExactly("AConfiguration", "springBean");

        SpringBean bean = context.getBean(SpringBean.class);
        bean.sayHello();
        context.close();


        AnnotationConfigApplicationContext contextB = new AnnotationConfigApplicationContext();
        contextB.getEnvironment().setActiveProfiles("bprofile");
        contextB.register(AppConfig.class);
        contextB.refresh();

        List<String> beansB = Arrays.stream(contextB.getBeanDefinitionNames())
                .filter(beanB -> !beanB.contains("org.springframework")
                        && !beanB.contains("appConfig"))
                .collect(Collectors.toList());
        Assertions.assertThat(beansB)
                .hasSize(2)
                .containsExactly("BConfiguration", "springBean");

        SpringBean beanB = contextB.getBean(SpringBean.class);
        beanB.sayHello();
        contextB.close();
    }
}
