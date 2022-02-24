package ch.wesr.spring.core.container.annotation.componentscan.autodectednaming;


import org.springframework.stereotype.Service;

@Service("meineHerzallerliebsteServiceBean")
public class ServiceBean {

    public void sayHello() {
        System.out.println("Hello from " + this.getClass().getSimpleName());
    }
}
