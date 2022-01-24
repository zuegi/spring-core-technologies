package ch.wesr.spring.core.container.xml.dependencyinjection.lifecyclecallback;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class SpringBeanLifecycleInterfaces implements InitializingBean, DisposableBean {

    private String message;


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.getClass().getSimpleName() +" afterPropertiesSet : " + message);
    }

    public void sayHello() {
        System.out.println("Hello from " +this.getClass().getSimpleName());
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Spring Container is destroy " +this.getClass().getSimpleName());
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
