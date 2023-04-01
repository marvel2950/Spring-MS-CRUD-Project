package com.helloms.controller;

import com.helloms.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class HelloControllerImpl implements HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public String helloWorld(){
        return helloService.helloWorld();
    }

}
