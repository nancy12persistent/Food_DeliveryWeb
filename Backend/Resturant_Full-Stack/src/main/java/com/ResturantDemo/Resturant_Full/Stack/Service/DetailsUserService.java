package com.ResturantDemo.Resturant_Full.Stack.Service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.ResturantDemo.Resturant_Full.Stack.Model.DetailsUser;
import com.ResturantDemo.Resturant_Full.Stack.Model.User;
import com.ResturantDemo.Resturant_Full.Stack.Repository.DetailsUser_repository;
import com.ResturantDemo.Resturant_Full.Stack.Repository.User_Repository;
import com.ResturantDemo.Resturant_Full.Stack.payloadResponse.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DetailsUserService {
    @Autowired
    private DetailsUser_repository detailsUser_repository;

    //Adding details of user
    public ResponseEntity<Object> addUser(DetailsUser user)
    {
        DetailsUser user1 = detailsUser_repository.findByFirstname(user.getFirstname());
        if(user1!=null){
           return LoginResponse.generateResponse("User details already exist!",HttpStatus.OK,user1);
        }else {
            try {
                detailsUser_repository.save(user);
                return LoginResponse.generateResponse("User details saved", HttpStatus.ACCEPTED,user);
            } catch (Exception err) {
                System.out.println(err);
            }
        }
        return LoginResponse.generateResponse("consider above message",HttpStatus.OK,user);
    }
}
