package com.kcwebapply.batch.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BatchJob{

    @Scheduled(initialDelay = 1000, fixedDelay = 1000)
    public void job(){
        System.out.println("job");
    }

}
