package ch.wesr.spring.core.container.xml.dependencyinjection.methodinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AlwaysTheSamePrototypeBeanRunner {

    public static void main(String[] args) {
        System.out.println("Beschreibung: Setter based injection -> es wird immer dasselbe PrototypeBean zurückgegeben");
        ApplicationContext context = new ClassPathXmlApplicationContext("dependencies/methodinjection/setter-base-injection.xml");
        SingletonBean singleton = (SingletonBean)context.getBean("singletonBean");
        PrototypeBean prototypeBeanA = singleton.getPrototypeBean();
        PrototypeBean prototypeBeanB = singleton.getPrototypeBean();

        prototypeBeanA.sayHello("prototypeBeanA");
        prototypeBeanB.sayHello("prototypeBeanB");
        System.out.println("Ist da  prototypeBeanA und prototypeBeanA  dasselbe ? " + (prototypeBeanA==prototypeBeanB));
        System.out.println("\n");

        System.out.println("Beschreibung: method injection > es wird immer eine Methode im PrototypeBean gesucht, instanziert und diese zurückgegeben");
        ApplicationContext contextMethodInjection = new ClassPathXmlApplicationContext("dependencies/methodinjection/method-injection.xml");
        AbstractSingletonBean abstractSingletonBean = (AbstractSingletonBean)contextMethodInjection.getBean("abstractSingletonBean");
        PrototypeBean injectedPrototypeBeanA = abstractSingletonBean.getPrototypeBean();
        PrototypeBean injectedPrototypeBeanB = abstractSingletonBean.getPrototypeBean();

        injectedPrototypeBeanA.sayHello("injectedPrototypeBeanA");
        injectedPrototypeBeanB.sayHello("injectedPrototypeBeanB");
        System.out.println("Ist da  prototypeBeanA und prototypeBeanA  dasselbe ? " + (injectedPrototypeBeanA==injectedPrototypeBeanB));
    }
}
