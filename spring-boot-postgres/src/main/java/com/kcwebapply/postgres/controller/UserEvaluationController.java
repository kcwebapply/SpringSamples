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

import java.util.List;
import java.util.stream.Collectors;

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

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<UserResponseResource> getUsers(){
        long start = System.currentTimeMillis();
        List<Userdata> userdataList = userEvaluationRepository.findAll();
        List<UserResponseResource> responseResources =
                userdataList.stream().map(userdata -> UserDataFactory.userdataGenerator(userdata)).collect(Collectors.toList());
        long end = System.currentTimeMillis();
        System.out.println((end - start)  + "ms");
        return responseResources;

    }

}
