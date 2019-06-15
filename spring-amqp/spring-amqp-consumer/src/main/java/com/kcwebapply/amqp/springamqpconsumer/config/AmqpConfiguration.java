package com.kcwebapply.amqp.springamqpconsumer.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import org.aopalliance.aop.Advice;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.RetryInterceptorBuilder;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.ConditionalRejectingErrorHandler;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;



@Configuration
@EnableRabbit
@RequiredArgsConstructor
public class AmqpConfiguration {


    @Value(value = "${sample.queue.name}")
    private String queueName;

    private final ConnectionFactory rabbitConnectionFactory;


    @Bean("sampleContainerFactory")
    public SimpleRabbitListenerContainerFactory ListenerContainerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setMessageConverter(jackson2JsonMessageConverter());
        factory.setConnectionFactory(rabbitConnectionFactory);
        factory.setErrorHandler(new ConditionalRejectingErrorHandler(t -> true));
        factory.setAdviceChain(
                new Advice[]{RetryInterceptorBuilder
                        .stateless()
                        .maxAttempts(1)
                        .backOffOptions(1000, 1, 1000)
                        .build()});
        return factory;
    }


    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
                .modules(new JavaTimeModule())
                .dateFormat(new StdDateFormat())
                .timeZone("Asia/Tokyo")
                .build();
        Jackson2JsonMessageConverter jackson2JsonMessageConverter
                = new Jackson2JsonMessageConverter(objectMapper);

        return jackson2JsonMessageConverter;
    }



    @Bean
    public FanoutExchange fanoutSampleExchange() {
        return new FanoutExchange("sample.exchange");
    }

    @Bean
    public Queue sampleQueue() {
        return new Queue(queueName);
    }

    @Bean
    public Binding Binding1(FanoutExchange fanoutSampleExchange,
                            Queue sampleQueue) {
        return BindingBuilder.bind(sampleQueue).to(fanoutSampleExchange);
    }

}
