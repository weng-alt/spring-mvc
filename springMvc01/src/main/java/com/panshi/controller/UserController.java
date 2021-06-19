package com.panshi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("hello")
    public String Hello(){
        System.out.println("进来了");
        return "../hello.jsp";
    }
}
