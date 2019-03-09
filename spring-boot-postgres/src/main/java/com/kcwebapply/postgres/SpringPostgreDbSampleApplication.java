package com.kcwebapply.postgres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.kcwebapply.postgres")
@EntityScan(basePackages = "com.kcwebapply.postgres.model")
@EnableJpaRepositories("com.kcwebapply.postgres.repository")
public class SpringPostgreDbSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPostgreDbSampleApplication.class, args);
	}
}
