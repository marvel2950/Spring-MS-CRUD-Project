package com.helloms.service;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    public String helloWorld(){
        return "Hello Akarsh !";
    }
}
