package com.kcwebapply.postgres.Factory;

import com.kcwebapply.postgres.model.Userdata;


public class UserDataFactory {

    public static UserResponseResource userdataGenerator(Userdata userdata){
        if(userdata == null){
            return new UserResponseResource();
        }

        userdata.getPosts().stream().forEach(post ->{
            System.out.println("postid:"+post.getUser_id()+" post-title"+post.getTitle());
        });

        return new UserResponseResource(
                userdata.getId(),
                userdata.getName(),
                userdata.getScore(),
                userdata.getPosts()
        );
    }
}
