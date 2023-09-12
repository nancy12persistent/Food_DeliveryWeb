package com.ResturantDemo.Resturant_Full.Stack.Repository;

import com.ResturantDemo.Resturant_Full.Stack.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Order_repository extends JpaRepository<Order,Integer> {
}
