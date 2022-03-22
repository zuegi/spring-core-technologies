package ch.wesr.spring.core.container.annotation.environment.profileonmethod;

import ch.wesr.spring.core.container.annotation.environment.profile.beans.SpringBean;
import org.assertj.core.api.Assertions;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProfileRunner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("aprofile", "bprofile");
        // wichtig ist, dass die activeProfiles zuerst gesetzt werden und erst dann die AppConfig.class registriert wird.
        context.register(AppConfig.class);
        context.refresh();

        List<String> beans = Arrays.stream(context.getBeanDefinitionNames())
                .filter(bean -> !bean.contains("org.springframework")
                        && !bean.contains("appConfig"))
                .collect(Collectors.toList());
        Assertions.assertThat(beans)
                .hasSize(2)
                .containsExactly("springBean", "springBeanB");

        SpringBean bean = (SpringBean) context.getBean("springBean");
        bean.sayHello();

        SpringBean beanB = (SpringBean) context.getBean("springBeanB");
        beanB.sayHello();

        context.close();
    }
}
