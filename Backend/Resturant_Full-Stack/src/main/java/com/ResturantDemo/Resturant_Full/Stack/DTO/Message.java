package com.ResturantDemo.Resturant_Full.Stack.DTO;

import lombok.Data;

@Data
public class Message {
    private String role;       //access
    private String content;   //promt you are searching for

    public Message(){}
    public Message(String role, String content) {
        this.role = role;
        this.content = content;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
