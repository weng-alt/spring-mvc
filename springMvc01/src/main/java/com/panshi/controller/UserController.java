package com.panshi.controller;

import com.panshi.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/hello")
    public String Hello(){
        System.out.println("进来了,lll");
        return "hello";
    }

    @GetMapping("/test1/{name}")
    public String test1(@PathVariable String name){
        System.out.println("test1进来了"+name);
        return "hello";
    }

    @PostMapping("/ajax")
    public String ajax(@RequestBody Student student){
        System.out.println(student);
        return "hello";
    }



}
