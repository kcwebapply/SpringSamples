package com.kcwebapply.postgres.repository;

import com.kcwebapply.postgres.model.Userdata;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;


@Repository
public interface UserEvaluationRepository extends JpaRepository<Userdata,String> {

    @EntityGraph(value = "Userdata.posts" , type=EntityGraphType.FETCH)
    Userdata getById(int id);

    @EntityGraph(value = "Userdata.posts" , type=EntityGraphType.FETCH)
    @Override
    List<Userdata> findAll();

}
