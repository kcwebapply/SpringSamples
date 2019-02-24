package com.kcwebapply.swagger.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleAPI {

    @RequestMapping(value = "/sample")
    public String sampleGetAPI(){
        return "ok";
    }
}
