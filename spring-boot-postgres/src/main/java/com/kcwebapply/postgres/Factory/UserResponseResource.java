package com.kcwebapply.postgres.Factory;


import com.kcwebapply.postgres.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseResource implements Serializable {

    private int userid;

    private String name;

    private int score;

    private List<Post> postList;
}
