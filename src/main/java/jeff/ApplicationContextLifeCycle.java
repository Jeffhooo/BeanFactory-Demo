package jeff;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextLifeCycle {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        A a = (A)context.getBean("a");
        C c = a.getC();

        CConfig cc = (CConfig)context.getBean("jeff.CConfig");
        C ccc = cc.C();
        System.out.println("c == ccc: " + (c == ccc));

//      Console Output:
//      Call B constructor.
//      Call A constructor.
//      Call CImp constructor.
//      Call A.setName: jeff
//      Call A.setValue: C438
//      Call AInit, set height as 170
//      Call A constructor.
//      c == ccc: true
    }
}
