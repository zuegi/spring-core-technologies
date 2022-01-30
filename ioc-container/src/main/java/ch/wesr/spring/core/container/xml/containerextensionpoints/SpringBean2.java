package ch.wesr.spring.core.container.xml.containerextensionpoints;

public class SpringBean2 {

    public void sayHello() {
        System.out.println("Hello from " +this.getClass().getSimpleName());
    }

    public void customBeanInit() {
        System.out.println(this.getClass().getSimpleName() + ".customBeanInit(): aufgerufen über das Bean Defintion Attribut init-method customBeanInit() ");
    }

    public void customBeanDestroy() {
        System.out.println(this.getClass().getSimpleName() + ".customBeanDestroy(): aufgerufen über das Bean Definition Atrribut destroy-method customBeanDestry() ");
    }
}

