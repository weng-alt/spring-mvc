package com.panshi.controller;

import com.panshi.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;


@Controller
@RequestMapping("/user")
public class UserController {


    @GetMapping("/hello")
    public String Hello() {
        System.out.println("进来了,lll");
        return "hello";
    }

    @GetMapping("/test1/{name}")
    public String test1(@PathVariable String name) {
        System.out.println("test1进来了" + name);
        return "hello";
    }

    @GetMapping("/test2")
    public String test2(Student student) {
        System.out.println(student);
        return "hello";
    }
test


    @PostMapping("/upload")
    @ResponseBody
    public String upload(HttpServletRequest req, MultipartFile file) {
        String path = req.getServletContext().getRealPath("/uploads/");
        File f = new File(path);
        if (!f.exists())
            f.mkdirs();
        String fileName = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");

        fileName = uuid + "_" + fileName;
        System.out.println(path);
        try {
            file.transferTo(new File(path,fileName));
        } catch (IOException e) {
            System.err.println("上传文件失败");
        }
        return "";
    }


}
