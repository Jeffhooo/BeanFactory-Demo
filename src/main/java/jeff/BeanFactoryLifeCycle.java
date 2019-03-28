package jeff;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class BeanFactoryLifeCycle {
    public static void main(String[] args) {
        // Get resource from bean.xml file
        Resource res = new ClassPathResource("bean.xml");

        BeanFactory bf = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((DefaultListableBeanFactory)bf);
        reader.loadBeanDefinitions(res);

        // AddBeanPostProcessor to IoC
        ((ConfigurableBeanFactory)bf).addBeanPostProcessor(new AbeanPostProcessor());
        ((ConfigurableBeanFactory)bf).addBeanPostProcessor(new AInstantiationAwareBeanPostProcessor());

        A a = (A)bf.getBean("a");
        A aa = (A)bf.getBean("a");
        System.out.println("a == aa: " + (a == aa));

        try {
            B b = a.getB();
            System.out.println("b is " + b.getName());
        } catch (NullPointerException e) {
            System.out.println("b is not autowired.");
        }

        ((DefaultListableBeanFactory)bf).destroySingletons();

//      Console output:
//      AInstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation
//      Call A constructor.
//      AInstantiationAwareBeanPostProcessor.postProcessAfterInstantiation
//      AInstantiationAwareBeanPostProcessor.postProcessPropertyValues
//      Call A.setName: jeff
//      Call A.setValue: C438
//      Call ABeanPostProcessor.postProcessAfterInitialization
//      Call AInit, set height as 170
//      Call ABeanPostProcessor.postProcessAfterInitialization
//      a == aa: true
//      b is not autowired.
//      Call ADestroy.
    }
}
