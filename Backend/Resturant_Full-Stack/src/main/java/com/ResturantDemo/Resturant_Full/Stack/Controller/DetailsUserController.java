package com.ResturantDemo.Resturant_Full.Stack.Controller;

import com.ResturantDemo.Resturant_Full.Stack.Model.DetailsUser;
import com.ResturantDemo.Resturant_Full.Stack.Service.DetailsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class DetailsUserController {
    @Autowired
    private DetailsUserService detailsUserService;

    @PostMapping("/addDetails")
    public ResponseEntity<Object> add(@RequestBody DetailsUser detailsUser){
        return detailsUserService.addUser(detailsUser);

    }

}
