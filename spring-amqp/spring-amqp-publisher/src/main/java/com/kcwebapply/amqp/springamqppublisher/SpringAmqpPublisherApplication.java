package com.kcwebapply.amqp.springamqppublisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan(basePackages = "com.kcwebapply.amqp.springamqppublisher")
public class SpringAmqpPublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAmqpPublisherApplication.class, args);
	}

}
