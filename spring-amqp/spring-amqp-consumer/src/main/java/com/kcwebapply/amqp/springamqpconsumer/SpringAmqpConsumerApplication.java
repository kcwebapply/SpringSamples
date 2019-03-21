package com.kcwebapply.amqp.springamqpconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.kcwebapply.amqp")
public class SpringAmqpConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAmqpConsumerApplication.class, args);
	}

}
