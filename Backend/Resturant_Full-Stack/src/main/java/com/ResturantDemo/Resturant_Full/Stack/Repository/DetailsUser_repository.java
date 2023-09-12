package com.ResturantDemo.Resturant_Full.Stack.Repository;

import com.ResturantDemo.Resturant_Full.Stack.Model.DetailsUser;
import com.ResturantDemo.Resturant_Full.Stack.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsUser_repository extends JpaRepository<DetailsUser, Integer> {
    DetailsUser findByFirstname(String firstname);
}
