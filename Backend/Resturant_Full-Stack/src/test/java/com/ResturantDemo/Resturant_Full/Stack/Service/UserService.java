package com.ResturantDemo.Resturant_Full.Stack.Service;

import com.ResturantDemo.Resturant_Full.Stack.DTO.loginDTO;
import com.ResturantDemo.Resturant_Full.Stack.Model.User;
import com.ResturantDemo.Resturant_Full.Stack.Repository.User_Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserService {

    @Autowired
    private User_Service service;

    @MockBean
    private User_Repository repo;
    private User user;
    private loginDTO  login;

    @BeforeEach
    public void setup() {
        User user = new User(2,"Amisha","Verma","Amisha12@gmail.com","Amisha@123#","Amish@123","data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD//gAfQ29tcHJlc3NlZCBieSB3P/2wCEAAQEBAQEBAQxEUEA8QFBEeFxUVFx4iHRsdIiolJSo");
        System.out.println(user);
        // Mockito.when(repo.findByName("Namisha Gupta")).thenReturn(employee);
    }

    //Save User
    @Test
    public void testSaveUser(){
        service.saveUser(user);
        assertThat(user).isNotNull();
    }

    // Get  User By Email and Password
    //Find by name
    @Test
    public void testGetEmployeeByName() {
        loginDTO login=new loginDTO("Amisha12@gmail.com","Amisha@123#");
        //given
        given(repo.findOneByEmailAndPassword("Amisha12@gmail.com","Amisha@123#")).willReturn(user);
        // when
        Object user1 = service.loginEmployee(login);

        // then
        assertThat(user1).isNotNull();
    }


    }
