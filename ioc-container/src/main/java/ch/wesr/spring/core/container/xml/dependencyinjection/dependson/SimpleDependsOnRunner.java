package ch.wesr.spring.core.container.xml.dependencyinjection.dependson;

import ch.wesr.spring.core.container.xml.beans.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SimpleDependsOnRunner {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("dependencies/dependson/depends-on.xml");
        DependsOnBean bean = context.getBean(DependsOnBean.class);
        bean.sayHello();

        BigDecimal teiler = new BigDecimal("0.256");
        BigDecimal zahl = new BigDecimal("5.000");
        zahl.divide(teiler, RoundingMode.CEILING);
    }
}
