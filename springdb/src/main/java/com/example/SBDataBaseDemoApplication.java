package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = "demo.domain")
@EnableJpaRepositories("demo.domain")
//@EntityScan(basePackages = "demo.domain")
//@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(
		scopedProxy = ScopedProxyMode.TARGET_CLASS,
		basePackages = {"demo.service","demo.domain"}
		)
public class SBDataBaseDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SBDataBaseDemoApplication.class, args);
	}
}
