package ch.wesr.spring.core.container.annotation.resources;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class SpringBeanExplorer {

    @Resource(name = "allerweltsBean")
    private SpringBean bean;

    @Resource
    private SpringBean2 halloBean;

    @Resource
    ApplicationContext context;

    public void explore() {
        context.getBeanDefinitionNames();
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println("bean defintion name: " +beanDefinitionName);
        }
        bean.sayHello();
        halloBean.sayHello();
    }
}
