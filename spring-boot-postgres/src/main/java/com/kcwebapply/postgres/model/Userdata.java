package com.kcwebapply.postgres.model;


import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "userdata")
@Data
@NamedEntityGraph(name="Userdata.posts",
        attributeNodes = {
                @NamedAttributeNode(value="name"),
                @NamedAttributeNode(value="score"),
                @NamedAttributeNode(value="posts")
        },
        subgraphs = {
                @NamedSubgraph(name="post.graph",
                        attributeNodes = {
                                @NamedAttributeNode(value="title"),
                                @NamedAttributeNode(value="content")
                        }
                        )
        }
)
public class Userdata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="score")
    private int score;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

}
