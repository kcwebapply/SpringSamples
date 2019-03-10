package com.kcwebapply.postgres.model;


import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "userdata")
@Data
public class Userdata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="score")
    private int score;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Post> posts;

}
