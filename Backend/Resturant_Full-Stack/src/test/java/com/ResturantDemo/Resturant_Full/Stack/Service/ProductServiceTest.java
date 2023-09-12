package com.ResturantDemo.Resturant_Full.Stack.Service;

import com.ResturantDemo.Resturant_Full.Stack.Model.Product;
import com.ResturantDemo.Resturant_Full.Stack.Service.productService;
import com.ResturantDemo.Resturant_Full.Stack.Repository.Product_Repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Autowired
    private productService service;

    @MockBean
    private Product_Repository repo;
    private Product product;

    @BeforeEach
    public void setup() {
        Product product =new Product(1,"Mango","Fruits",25,"Fresh Mangoes","data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD//gAfQ29tcHJlc3NlZCBieSB3P/2wCEAAQEBAQEBAQxEUEA8QFBEeFxUVFx4iHRsdIiolJSo");
        System.out.println(product);


    }
    //Save Product
    @Test
    public void testSaveProduct(){
        // given
        given(repo.save(product)).willReturn(product);
        // when
        ResponseEntity<Object> product1 = service.saveProduct(product);
        // then
        assertThat(product1).isNotNull();
    }

}
