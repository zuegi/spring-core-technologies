package ch.wesr.spring.core.container.xml.dependencyinjection.lifecyclecallback.startupshutdown;

import org.springframework.context.Lifecycle;
import org.springframework.context.LifecycleProcessor;
import org.springframework.context.Phased;
import org.springframework.context.SmartLifecycle;

public class SpringBeanLifecycle implements LifecycleProcessor, SmartLifecycle {

    private boolean running = false;

    public void sayHello() {
        System.out.println(this.getClass().getSimpleName() +" sagt Hallo");
    }

    @Override
    public void onRefresh() {
        System.out.println(this.getClass().getSimpleName() + " - REFRESH.");
        running = true;
    }

    @Override
    public void onClose() {
        System.out.println(this.getClass().getSimpleName() + " - CLOSE.");
        running = false;
    }

    @Override
    public void start() {
        System.out.println(this.getClass().getSimpleName() + " - START.");
        running = true;
    }

    @Override
    public void stop() {
        System.out.println(this.getClass().getSimpleName() + " - STOP.");
        running = false;
    }

    public void stop(Runnable callback) {
        System.out.println(this.getClass().getSimpleName() + " callback: - STOP.");
        stop();
        callback.run();
    }

    @Override
    public boolean isRunning() {
        return running;
    }
}
