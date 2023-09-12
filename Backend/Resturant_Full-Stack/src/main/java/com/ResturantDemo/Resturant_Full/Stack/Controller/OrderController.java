package com.ResturantDemo.Resturant_Full.Stack.Controller;

import com.ResturantDemo.Resturant_Full.Stack.Model.OrderItems;
import com.ResturantDemo.Resturant_Full.Stack.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Post order with userId
     @PostMapping("order/{userId}/{productId}")
    public String createOrder(@RequestBody OrderItems items, @PathVariable Integer userId, @PathVariable Integer productId){
        return this.orderService.placeOrder(items, userId , productId);
    }

}
