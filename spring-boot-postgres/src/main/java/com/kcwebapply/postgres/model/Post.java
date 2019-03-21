package com.kcwebapply.postgres.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.apache.catalina.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="post")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="user_id",insertable = false,updatable = false)
    private int user_id;

    @Column(name="title")
    private String title;

    @Column(name="content")
    private String content;

    @ManyToOne
    @JsonIgnore
    private Userdata user;


}
