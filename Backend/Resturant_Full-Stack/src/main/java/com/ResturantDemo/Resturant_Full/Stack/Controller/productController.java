package com.ResturantDemo.Resturant_Full.Stack.Controller;

import com.ResturantDemo.Resturant_Full.Stack.DTO.PaymentDTO;
import com.ResturantDemo.Resturant_Full.Stack.DTO.loginDTO;
import com.ResturantDemo.Resturant_Full.Stack.Model.Product;
import com.ResturantDemo.Resturant_Full.Stack.Service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class productController {
    @Autowired
    private productService productService;

    @PostMapping("/saveProduct")
    public ResponseEntity<Object> saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }
    @GetMapping("/getProducts")
    public List<Product>GetProducts()
    {
        return productService.getAllProducts();
    }

    @PostMapping("/PaymentGateway")
    public  ResponseEntity<Object> createPayment(@RequestBody PaymentDTO paymentDTO){
        return productService.createPayment(paymentDTO);
    }

}

