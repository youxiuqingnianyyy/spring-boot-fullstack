package com.yyy.demo.customer;

public record CustomerRegistrationRequest (
        String name,
        String email,
        Integer age
){
}
