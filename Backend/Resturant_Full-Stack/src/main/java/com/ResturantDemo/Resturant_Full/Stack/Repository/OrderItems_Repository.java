package com.ResturantDemo.Resturant_Full.Stack.Repository;

import com.ResturantDemo.Resturant_Full.Stack.Model.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItems_Repository extends JpaRepository<OrderItems, Integer> {
}
