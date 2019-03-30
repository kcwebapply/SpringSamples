package com.kcwebapply.postgres.Factory;

import com.kcwebapply.postgres.model.Userdata;


public class UserDataFactory {

    public static UserResponseResource userdataGenerator(Userdata userdata){
        if(userdata == null){
            return new UserResponseResource();
        }

        return new UserResponseResource(
                userdata.getId(),
                userdata.getName(),
                userdata.getScore(),
                userdata.getPosts()
        );
    }
}
