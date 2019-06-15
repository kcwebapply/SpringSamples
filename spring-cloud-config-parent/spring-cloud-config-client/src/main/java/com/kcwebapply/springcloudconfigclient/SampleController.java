package com.kcwebapply.springcloudconfigclient;


import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties(value = AppConfigProperties.class)
public class SampleController {


    private final AppConfigProperties appConfigProperties;

    public SampleController(AppConfigProperties appConfigProperties){
        this.appConfigProperties = appConfigProperties;
    }

    @GetMapping(value = "/sample")
    public String dev(){
        return appConfigProperties.getUrl();
    }
}
