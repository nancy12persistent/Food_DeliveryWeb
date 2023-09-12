package com.ResturantDemo.Resturant_Full.Stack.Repository;

import com.ResturantDemo.Resturant_Full.Stack.Model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserRepo {

    @Autowired
    private User_Repository repo;


    User user =new User(2,"Amisha","Verma","Amisha12@gmail.com","Amisha@123#","Amish@123","data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD//gAfQ29tcHJlc3NlZCBieSB3P/2wCEAAQEBAQEBAQxEUEA8QFBEeFxUVFx4iHRsdIiolJSo");
    //Junit test for save User
    @Test
    public void saveUserTest() {
        User user1 =new User(1,"Amita","Sharma","Amita12@gmail.com","Amita@123#","Amita@123","data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD//gAfQ29tcHJlc3NlZCBieSB3P/2wCEAAQEBAQEBAQxEUEA8QFBEeFxUVFx4iHRsdIiolJSo");
        Assertions.assertThat(user1.getId()).isGreaterThan(0);
    }

    //Junit test to get all USers
    @Test
    public void getListOfUsersTest(){
        List<User> user1 = repo.findAll();
        Assertions.assertThat(user1.size()).isGreaterThan(0);
    }
    //Junit test to get User By Email and Password
    @Test
    public void getEmployeeByEmailAndPasswordTest(){
        repo.save(user);
        User user1 = repo.findOneByEmailAndPassword("Amisha12@gmail.com","Amisha@123#");
        int id2=user1.getId();
        Assertions.assertThat(user.getId()).isEqualTo(id2);

    }


}
