package jeff;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class BeanLifeCycle {
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
        a.say();
        a.setValue("C001");

        A aa = (A)bf.getBean("a");

        System.out.println("a == aa: " + (a == aa));

        ((DefaultListableBeanFactory)bf).destroySingletons();

//        Console output:
//        MyInstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation
//        Call A constructor.
//                InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation
//        InstantiationAwareBeanPostProcessor.postProcessPropertyValues
//        Call A.setName: jeff
//        Call A.setValue: C438
//        Call MyBeanPostProcessor.postProcessAfterInitialization, a is shorter than 170. Set a to 170.
//        Call AInit, set height as 170
//        Call MyBeanPostProcessor.postProcessAfterInitialization, a is higher than 160. Set a to 160.
//        Hello, My name is jeff.
//                Call A.setValue: C001
//        a == aa: true
//        Call ADestroy.
    }
}
