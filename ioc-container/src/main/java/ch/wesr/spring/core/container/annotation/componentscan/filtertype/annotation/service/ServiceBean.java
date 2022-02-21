package ch.wesr.spring.core.container.annotation.componentscan.filtertype.annotation.service;

import ch.wesr.spring.core.container.annotation.componentscan.filtertype.annotation.BenutzerDefinierterScan;

@BenutzerDefinierterScan
public class ServiceBean {
    public void sayHello() {
        System.out.println("Hello from " +this.getClass().getSimpleName());
    }
}
