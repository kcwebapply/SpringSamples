package com.kcwebapply.postgres.controller;


import com.kcwebapply.postgres.Factory.UserDataFactory;
import com.kcwebapply.postgres.repository.UserEvaluationRepository;
import com.kcwebapply.postgres.Factory.UserResponseResource;
import com.kcwebapply.postgres.model.Userdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserEvaluationController {

    @Autowired
    UserEvaluationRepository userEvaluationRepository;

    @RequestMapping(value = "/users/{userId}",method = RequestMethod.GET)
    public UserResponseResource getUserData(@PathVariable int userId){
        long start = System.currentTimeMillis();
        Userdata userData = userEvaluationRepository.findById(userId);
        long end = System.currentTimeMillis();
        System.out.println((end - start)  + "ms");
        return UserDataFactory.userdataGenerator(userData);

    }

}
