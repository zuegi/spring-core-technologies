package ch.wesr.spring.core.container.annotation.componentscan.filtertype.annotation.explore;

import ch.wesr.spring.core.container.annotation.componentscan.filtertype.annotation.service.ServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BeanExplorer {

    @Autowired
    ServiceBean serviceBean;

    public void explore() {
        serviceBean.sayHello();
    }
}
