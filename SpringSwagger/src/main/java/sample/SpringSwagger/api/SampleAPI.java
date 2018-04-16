package sample.SpringSwagger.api;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleAPI {

    @RequestMapping(value = "/sample")
    public String sampleGetAPI(){
        return "ok";
    }
}
