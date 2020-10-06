package tw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@SpringBootApplication(scanBasePackages = "tw")
@EntityScan(basePackages = "tw.model")
@EnableJpaRepositories(basePackages = "tw.repository")
public class SpringDataApplication extends SpringBootServletInitializer {
    public static void main(String[] args){
        SpringApplication.run(SpringDataApplication.class);
    }
}
