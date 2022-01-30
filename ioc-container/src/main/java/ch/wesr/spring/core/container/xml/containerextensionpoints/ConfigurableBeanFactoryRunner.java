package ch.wesr.spring.core.container.xml.containerextensionpoints;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class ConfigurableBeanFactoryRunner {

    public static void main(String[] args) {

        ClassPathResource classPathResource = new ClassPathResource("dependencies/containerextensionpoints/bean-post-processor.xml");
        ConfigurableBeanFactory configurableBeanFactory = new XmlBeanFactory(classPathResource);
        CustomBeanPostProcessor customPostProcessorBean = (CustomBeanPostProcessor) configurableBeanFactory.getBean("customPostProcessorBean");

        configurableBeanFactory.addBeanPostProcessor(customPostProcessorBean);

        SpringBean springBean = (SpringBean) configurableBeanFactory.getBean("springBean");
        springBean.sayHello();


    }
}
