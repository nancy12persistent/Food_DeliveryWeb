package com.ResturantDemo.Resturant_Full.Stack.Service;

import com.ResturantDemo.Resturant_Full.Stack.DTO.loginDTO;
import com.ResturantDemo.Resturant_Full.Stack.Model.Product;
import com.ResturantDemo.Resturant_Full.Stack.Model.User;
import com.ResturantDemo.Resturant_Full.Stack.Repository.User_Repository;
import com.ResturantDemo.Resturant_Full.Stack.payloadResponse.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class User_Service {
    @Autowired
    private User_Repository userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    //Creating user
    public String saveUser(User user)
    {
         User user1 = userRepo.getUserByEmail(user.getEmail());
        if(user1!=null){
            return "Email already exists!";
        }else{
      /*  User user1=new User(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail(),
                user.getImage(),
                this.passwordEncoder.encode(user.getPassword()),
                this.passwordEncoder.encode(user.getConfirmPassword())
        );*/
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        user.setConfirmPassword(this.passwordEncoder.encode(user.getConfirmPassword()));
        userRepo.save(user);
        return "New user registered!";}
    }
    // Get all Users
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public ResponseEntity<Object> loginEmployee(loginDTO loginDTO) {
        String msg = "";
        User user1 = userRepo.findByEmail(loginDTO.getEmail());
        if (user1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
               User user = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (user!=null) {
                    System.out.println(user);
                    System.out.println(user1);
                    return LoginResponse.generateResponse("Login Success",HttpStatus.OK,user);

                } else {
                    return LoginResponse.generateResponse("Login Failed", HttpStatus.MULTI_STATUS,null);
                }
            } else {

                return LoginResponse.generateResponse("password Not Match",HttpStatus.NO_CONTENT,null);
            }
        }else {
            return LoginResponse.generateResponse("Email not exits", HttpStatus.NOT_FOUND,null);
        }
    }
    }

