package com.kcwebapply.amqp.springamqppublisher.service;


import com.kcwebapply.amqp.springamqppublisher.service.resources.SampleMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitScheduler implements CommandLineRunner {

    @Value(value = "${sample.queue.name}")
    private String queueName;

    private final RabbitTemplate rabbitTemplate;


    @Override
    public void run(String... strings) throws InterruptedException {
        int id = 0;
        while(true){
            SampleMessage sampleMessage = new SampleMessage();
            sampleMessage.setMessage("test");
            sampleMessage.setMessageId(id);
            rabbitTemplate.convertAndSend(queueName,sampleMessage);
            rabbitTemplate.convertAndSend("sample.exchange",queueName);
            System.out.println("SEND MESSAGE:"+sampleMessage.toString());
            id++;
            Thread.sleep(1000);
        }

    }
}
