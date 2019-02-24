package com.kcwebapply.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.kcwebapply.db.demo.domain")
@EnableJpaRepositories("com.kcwebapply.db.demo.domain")
@ComponentScan(
		scopedProxy = ScopedProxyMode.TARGET_CLASS,
		basePackages = {"com.kcwebapply.db.demo.service","com.kcwebapply.db.demo.domain"}
		)
public class SBDataBaseDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(SBDataBaseDemoApplication.class, args);
	}
}
