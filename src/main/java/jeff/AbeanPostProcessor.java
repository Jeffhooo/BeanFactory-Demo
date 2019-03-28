package jeff;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class AbeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        if (s.equals("a")) {
            A a = (A)o;
            if (a.getHeight() <= 170) {
                System.out.println("Call ABeanPostProcessor.postProcessAfterInitialization");
                a.setHeight(170);
            }
        }
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        if (s.equals("a")) {
            A a = (A)o;
            if (a.getHeight() >= 160) {
                System.out.println("Call ABeanPostProcessor.postProcessAfterInitialization");
                a.setHeight(160);
            }
        }
        return o;
    }
}
