package com.ResturantDemo.Resturant_Full.Stack.Controller;
import static org.mockito.Mockito.*;
import  static org.hamcrest.Matchers.*;
import com.ResturantDemo.Resturant_Full.Stack.Model.User;
import com.ResturantDemo.Resturant_Full.Stack.Service.User_Service;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.mockito.Mockito.when;


public class UserController extends UserTest {

    @Autowired
    private MockMvc mockMvc;
    private WebApplicationContext webApplicationContext;

    private ObjectMapper objectMapper;

    @MockBean
    private User_Service user_service;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void testSaveUser() throws Exception{
        User user = new User();
        user.setId(1);
        user.setFirstname("Manisha");
        user.setLastname("Sharma");
        user.setEmail("ManishaSharma12@gmail.com");
        user.setPassword("Manisha@123");
        user.setConfirmPassword("Manisha@123");
        user.setImage("data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD//gAfQ29tcHJlc3NlZCBieSB3P/2wCEAAQEBAQEBAQxEUEA8QFBEeFxUVFx4iHRsdIiolJSo");

        Mockito.when(user_service.saveUser(user))
                .thenReturn("New user registered!");
        mockMvc.perform(post("/user/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(user)))
		        .andExpect(status().isCreated())
                .andExpect(content().string("New user registered!"));

    }

    private static String asJsonString(Object obj){
        try {
            return new ObjectMapper().writeValueAsString(obj);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
