package com.ResturantDemo.Resturant_Full.Stack.Model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orderItems")
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userOrderId;
    @Column(name = "date")
    private LocalDate addedDate;
    private int quantity;
    private double totalPrice;
    private String addressLine;
    private String country;
    private String state;
    private String city;
    private String zipCode;
    private String mobileNo;
    @ManyToOne
    private Product product;

    public OrderItems(){}

    public OrderItems(int userOrderId, LocalDate addedDate, int quantity, double totalPrice, String addressLine, String country, String state, String city, String zipCode, String mobileNo, Product product) {
        this.userOrderId = userOrderId;
        this.addedDate = addedDate;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.addressLine = addressLine;
        this.country = country;
        this.state = state;
        this.city = city;
        this.zipCode = zipCode;
        this.mobileNo = mobileNo;
        this.product = product;
    }

    public int getUserOrderId() {
        return userOrderId;
    }

    public void setUserOrderId(int userOrderId) {
        this.userOrderId = userOrderId;
    }

    public LocalDate getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(LocalDate addedDate) {
        this.addedDate = addedDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
