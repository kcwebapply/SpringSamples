package com.kcwebapply.amqp.springamqppublisher.service.resources;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class SampleMessage implements Serializable {

    private int messageId;

    private String message;

}
