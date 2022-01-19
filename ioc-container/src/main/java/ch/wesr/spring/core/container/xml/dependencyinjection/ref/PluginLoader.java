package ch.wesr.spring.core.container.xml.dependencyinjection.ref;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PluginLoader implements ApplicationContextAware {
    ApplicationContext parentApplicationContext;
    ConfigurableApplicationContext childContext;

    public void load() {
        //Scan all spring configuration files starting with plugin_ under the classpath for assembly.
        // It is agreed that all sub-container plug-ins must have a configuration file starting with plugin_, and this file is used by the parent container Load
        childContext = new ClassPathXmlApplicationContext("dependencies/ref/child-ref.xml");
        childContext.setParent(parentApplicationContext);
        childContext.refresh();
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.parentApplicationContext = applicationContext;
    }
}
