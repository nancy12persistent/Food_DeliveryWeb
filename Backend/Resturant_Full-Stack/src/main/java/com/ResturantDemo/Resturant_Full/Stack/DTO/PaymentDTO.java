package com.ResturantDemo.Resturant_Full.Stack.DTO;

import java.util.ArrayList;
import java.util.List;

public class PaymentDTO {
    private List<String> cartDetails=  new ArrayList<>();

    public PaymentDTO(){}

    public PaymentDTO(List<String> cartDetails) {
        this.cartDetails = cartDetails;
    }

    public List<String> getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(List<String> cartDetails) {
        this.cartDetails = cartDetails;
    }
}
