package jeff;

import org.springframework.stereotype.Component;

@Component
public class B {
    String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public B() {
        System.out.println("Call B constructor.");
    }
}
