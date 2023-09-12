package com.ResturantDemo.Resturant_Full.Stack.Repository;

import com.ResturantDemo.Resturant_Full.Stack.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface User_Repository extends JpaRepository<User,Integer>{
    User getUserByEmail(String email);
    User findByEmail(String email);
    Boolean existsByEmail(String email);

    User findOneByEmailAndPassword(String email, String password);

}
