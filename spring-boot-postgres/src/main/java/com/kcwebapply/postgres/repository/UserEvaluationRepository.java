package com.kcwebapply.postgres.repository;

import com.kcwebapply.postgres.model.Userdata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserEvaluationRepository extends JpaRepository<Userdata,String> {

    Userdata findById(int id);

}
