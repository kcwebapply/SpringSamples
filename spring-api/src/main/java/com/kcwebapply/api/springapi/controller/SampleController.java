package com.kcwebapply.api.springapi.controller;

import com.kcwebapply.api.springapi.controller.resource.SampleBody;
import com.kcwebapply.api.springapi.controller.resource.SampleResponse;
import com.kcwebapply.api.springapi.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class SampleController extends AbstractRestClientHandler{


    @GetMapping(value = "/api/sample/{vin}")
    @ResponseStatus(HttpStatus.OK)
    public String returnId(@PathVariable String id){
        if(id.length() != 4){
            throw new BadRequestException("bad request","1");
        }
        return id;
    }

    @PostMapping(value = "/api/sample")
    @ResponseStatus(HttpStatus.OK)
    public SampleResponse returnSample(@RequestBody SampleBody sampleBody){
        if(sampleBody == null){
            throw new BadRequestException("bad request","1");
        }
        SampleResponse response = new SampleResponse(
                sampleBody.getId(),sampleBody.getCountry().getCode()
        );

        return response;
    }

}



