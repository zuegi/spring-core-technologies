package ch.wesr.spring.core.container.xml.containerextensionpoints;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;

public class CustomFactoryBean implements FactoryBean<SpringBean> {

    private String message;
    private String beanName;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    @Override
    public SpringBean getObject() throws Exception {
        // stark vereinfacht hier um zu zeigen wie es geht
        SpringBean springBean = new SpringBean();
        springBean.setMessage(message);
        springBean.setBeanName(beanName);

        return springBean;
    }

    @Override
    public Class<?> getObjectType() {
        return SpringBean.class;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
