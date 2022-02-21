package ch.wesr.spring.core.container.annotation.componentscan.filtertype.assignabletype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpringBean {

    @Autowired
    SayHelloBean sayHelloBean;

    public void sayHello() {
        sayHelloBean.hello();
    }
}
