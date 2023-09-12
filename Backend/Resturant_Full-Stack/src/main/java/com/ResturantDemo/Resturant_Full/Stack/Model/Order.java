package com.ResturantDemo.Resturant_Full.Stack.Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    private LocalDate addedDate;
    private LocalDate shippingDate;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = OrderItems.class)
    @JoinColumn(name = "order_orderItems")
    private List<OrderItems> orderItems = new ArrayList<>();

    public Order(){}

    public Order(int id, int userId, LocalDate addedDate, LocalDate shippingDate, List<OrderItems> orderItems) {
        this.id = id;
        this.userId = userId;
        this.addedDate = addedDate;
        this.shippingDate = shippingDate;
        this.orderItems = orderItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDate getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(LocalDate addedDate) {
        this.addedDate = addedDate;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }

    public List<OrderItems> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItems> orderItems) {
        this.orderItems = orderItems;
    }
}
