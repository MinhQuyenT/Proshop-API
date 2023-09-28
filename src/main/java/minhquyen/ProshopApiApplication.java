package minhquyen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("minhquyen.repositories")
public class ProshopApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProshopApiApplication.class, args);
    }
}
