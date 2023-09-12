package com.ResturantDemo.Resturant_Full.Stack.Service;

import com.ResturantDemo.Resturant_Full.Stack.Exception.ResourceNotFoundException;
import com.ResturantDemo.Resturant_Full.Stack.Model.Order;
import com.ResturantDemo.Resturant_Full.Stack.Model.OrderItems;
import com.ResturantDemo.Resturant_Full.Stack.Model.Product;
import com.ResturantDemo.Resturant_Full.Stack.Model.User;
import com.ResturantDemo.Resturant_Full.Stack.Repository.OrderItems_Repository;
import com.ResturantDemo.Resturant_Full.Stack.Repository.Order_repository;
import com.ResturantDemo.Resturant_Full.Stack.Repository.Product_Repository;
import com.ResturantDemo.Resturant_Full.Stack.Repository.User_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private User_Repository repo;

    @Autowired
    private Order_repository OrderRepo;

    @Autowired
    private OrderItems_Repository OrderItemsrepo;

    @Autowired
    private Product_Repository productRepo;

    public String placeOrder(OrderItems orderItems1, Integer userId , Integer productId) {
        //User user = repo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user not found with this id" + userId));
       // Product product1 = productRepo.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product not found with this id" + productId));
       // List<CartDetails> cartDetailsList = cartDetailDao.findByUserId(userId);

        Product product1 = productRepo.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product not found with this id" + productId));

        Order order1 = new Order();
        order1.setUserId(userId);
        order1.setAddedDate(LocalDate.now());
        order1.setShippingDate(order1.getAddedDate().plusDays(7));
        List<OrderItems> orderdDetailsList = new ArrayList<>();
        OrderItems orderItems = new OrderItems();

        orderItems.setAddedDate(LocalDate.now());
        orderItems.setQuantity(orderItems1.getQuantity());
        orderItems.setAddressLine(orderItems1.getAddressLine());
        orderItems.setCity(orderItems1.getCity());
        orderItems.setCountry(orderItems1.getCountry());
        orderItems.setState(orderItems1.getState());
        orderItems.setMobileNo(orderItems1.getMobileNo());
        orderItems.setZipCode(orderItems1.getZipCode());
        orderItems.setTotalPrice(orderItems1.getTotalPrice());
        orderItems.setProduct(product1);
        orderdDetailsList.add(orderItems);

        order1.setOrderItems(orderdDetailsList);
        OrderRepo.save(order1);
        return "Order Placed";
    }

}
