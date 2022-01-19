package ch.wesr.spring.core.container.xml.dependencyinjection.compoundpropertynames;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CompoundPropertyNamesBeanRunner {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("dependencies/compoundpropertynames/compound-property-names.xml");
        CompoundPropertyNamesBean bean = context.getBean(CompoundPropertyNamesBean.class);
        bean.sayHello();
    }
}
