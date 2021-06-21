package com.panshi.controller;

import com.panshi.pojo.Student;
import com.panshi.service.StudentService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@Controller
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/test")
    @ResponseBody
    public List<Student> ajax() {
        return service.test();
    }

    @PostMapping("/upload")
    public String upload(HttpServletRequest req, MultipartFile file) {
        String path = req.getServletContext().getRealPath("/uploads/");
        File f = new File(path);
        if (!f.exists())
            f.mkdirs();
        String fileName = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");

        fileName = uuid + "_" + fileName;
        System.out.println(path);
        req.getSession().setAttribute("msg",fileName+"上传文件成功");
        try {
            file.transferTo(new File(path,fileName));
        } catch (IOException e) {
            System.err.println("上传文件失败");
        }
        return "hello";
    }


}
