package com.stackroute.RESTful.repository;

import com.stackroute.RESTful.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.lastName like %?1")
    List<User> getAllByLastName(String lastname);
}
