package ch.wesr.spring.core.container.annotation.environment.multipleprofiles;


import ch.wesr.spring.core.container.annotation.environment.beans.SpringBean;
import ch.wesr.spring.core.container.annotation.environment.multipleprofiles.config.AppConfig;
import org.assertj.core.api.Assertions;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProfileRunner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("aprofile", "cprofile");

        context.register(AppConfig.class);
        context.refresh();

        List<String> beans = Arrays.stream(context.getBeanDefinitionNames())
                .filter(bean -> !bean.contains("org.springframework")
                        && !bean.contains("appConfig"))
                .collect(Collectors.toList());
        Assertions.assertThat(beans)
                .hasSize(4)
                .containsExactly("AConfiguration", "CConfiguration", "springBean", "springBeanB");

        SpringBean bean = (SpringBean) context.getBean("springBean");
        bean.sayHello();

        SpringBean beanB = (SpringBean) context.getBean("springBeanB");
        beanB.sayHello();
        context.close();


    }
}
