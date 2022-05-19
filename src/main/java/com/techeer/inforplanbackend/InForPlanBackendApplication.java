package com.techeer.inforplanbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@EntityScan(basePackages = {"com.techeer.inforplanbackend"})
@SpringBootApplication
public class InForPlanBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(InForPlanBackendApplication.class, args);
    }

}
