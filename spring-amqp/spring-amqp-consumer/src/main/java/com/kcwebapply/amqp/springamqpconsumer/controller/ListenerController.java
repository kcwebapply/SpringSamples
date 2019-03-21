package com.kcwebapply.amqp.springamqpconsumer.controller;

import com.kcwebapply.amqp.springamqpconsumer.controller.resources.SampleMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerController {


    @RabbitListener(queues = "${sample.queue.name}",containerFactory = "sampleContainerFactory")
    public void messageReceiver(SampleMessage message){

        System.out.println("received:"+message);

    }
}


