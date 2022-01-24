package ch.wesr.spring.core.container.xml.dependencyinjection.lifecyclecallback;

public class InitDestroySpringBean {


    public void init() {
        System.out.println(this.getClass().getSimpleName() +" init() called ");
    }

    public void sayHello() {
        System.out.println("Hello from " +this.getClass().getSimpleName());
    }

    public void destroy() {
        System.out.println("Spring Container is destroy " +this.getClass().getSimpleName());
    }

}
