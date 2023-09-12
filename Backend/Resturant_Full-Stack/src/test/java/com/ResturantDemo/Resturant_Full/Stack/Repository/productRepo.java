package com.ResturantDemo.Resturant_Full.Stack.Repository;

import com.ResturantDemo.Resturant_Full.Stack.Model.Product;
import com.ResturantDemo.Resturant_Full.Stack.Repository.Product_Repository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class productRepo {

    @Autowired
    private Product_Repository repo;


    //Junit test for save Product
    @Test
    public void saveProductTest() {
        Product product1 =new Product(1,"Mango","Fruits",25,"Fresh Mangoes","data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD//gAfQ29tcHJlc3NlZCBieSB3P/2wCEAAQEBAQEBAQxEUEA8QFBEeFxUVFx4iHRsdIiolJSo");
        Assertions.assertThat(product1.getId()).isGreaterThan(0);
    }

    //Junit test to get all USers
    @Test
    public void getListOfProductTest(){
        List<Product> products = repo.findAll();
        Assertions.assertThat(products.size()).isGreaterThan(0);
    }


}
