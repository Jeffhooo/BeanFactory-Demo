package jeff;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class CConfig {

    @Bean
//  @Scope("prototype")
    public C CIf() {
        return new CImp();
    }
}
