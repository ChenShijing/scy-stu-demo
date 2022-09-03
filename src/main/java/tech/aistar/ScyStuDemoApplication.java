package tech.aistar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement    //开启事物
@SpringBootApplication
public class ScyStuDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScyStuDemoApplication.class, args);
    }

}
