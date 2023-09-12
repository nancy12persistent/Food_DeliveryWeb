package com.ResturantDemo.Resturant_Full.Stack.Service;

import com.ResturantDemo.Resturant_Full.Stack.DTO.PaymentDTO;
import com.ResturantDemo.Resturant_Full.Stack.Model.Product;
import com.ResturantDemo.Resturant_Full.Stack.Repository.Product_Repository;
import com.ResturantDemo.Resturant_Full.Stack.payloadResponse.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSInput;

import java.util.List;

@Service
public class productService {
    @Autowired
    private Product_Repository prodRepo;

    //Save product
    public ResponseEntity<Object> saveProduct(Product product){
     prodRepo.save(product);
     return LoginResponse.generateResponse("product saved successfully", HttpStatus.OK,product);
    }
    // Get all products
    public List<Product> getAllProducts(){
        return prodRepo.findAll();
    }

    //payment
    public  ResponseEntity<Object> createPayment(PaymentDTO paymentDTO){
        return LoginResponse.generateResponse("success",HttpStatus.OK,paymentDTO);
    }
}
