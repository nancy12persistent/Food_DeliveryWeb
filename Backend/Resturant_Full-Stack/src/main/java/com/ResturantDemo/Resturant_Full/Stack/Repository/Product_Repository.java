package com.ResturantDemo.Resturant_Full.Stack.Repository;

import com.ResturantDemo.Resturant_Full.Stack.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Product_Repository extends JpaRepository<Product,Integer> {

}
