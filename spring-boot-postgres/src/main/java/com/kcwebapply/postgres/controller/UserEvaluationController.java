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

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class UserEvaluationController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    UserEvaluationRepository userEvaluationRepository;

    @RequestMapping(value = "/users/{userId}",method = RequestMethod.GET)
    public UserResponseResource getUserData(@PathVariable int userId){
        Userdata userData = userEvaluationRepository.getById(userId);
        return UserDataFactory.userdataGenerator(userData);

    }

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<UserResponseResource> getUsers(){
        List<Userdata> userdataList = userEvaluationRepository.findAll();
        List<UserResponseResource> responseResources =
                userdataList.stream().map(userdata -> UserDataFactory.userdataGenerator(userdata)).collect(Collectors.toList());
        return responseResources;

    }


    @RequestMapping(value = "/usersgraph",method = RequestMethod.GET)
    public List<UserResponseResource> getUsersByGraph(){
        EntityGraph graph = entityManager.getEntityGraph("Userdata.posts");
        Map<String, Object> hints = new HashMap<>();
        hints.put("javax.persistence.fetchgraph", graph);
        Userdata user = entityManager.find(Userdata.class, 1, hints);
        UserResponseResource responseResource = UserDataFactory.userdataGenerator(user);
        return Arrays.asList(responseResource);
    }

}
