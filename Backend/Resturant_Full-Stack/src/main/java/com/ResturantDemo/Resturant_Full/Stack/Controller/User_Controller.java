package com.ResturantDemo.Resturant_Full.Stack.Controller;

import com.ResturantDemo.Resturant_Full.Stack.DTO.loginDTO;
import com.ResturantDemo.Resturant_Full.Stack.Model.Product;
import com.ResturantDemo.Resturant_Full.Stack.Model.User;
import com.ResturantDemo.Resturant_Full.Stack.Service.User_Service;
import com.ResturantDemo.Resturant_Full.Stack.payloadResponse.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class User_Controller {
    @Autowired
    private User_Service user_service;

    @PostMapping("/signup")
    public String add(@RequestBody User user){
        return user_service.saveUser(user);

    }
    @PostMapping("/login")
    public ResponseEntity<Object>loginEmployee(@RequestBody loginDTO loginDTO)
    {
        return user_service.loginEmployee(loginDTO);
       // return LoginResponse.generateResponse("Successfully logged in!", HttpStatus.OK,result);
    }

    @GetMapping("/getAllUsers")
    public List<User> GetUsers()
    {
        return user_service.getAllUsers();
    }
}
