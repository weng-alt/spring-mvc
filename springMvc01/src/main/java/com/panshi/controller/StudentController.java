package com.panshi.controller;

import com.panshi.entity.Msg;
import com.panshi.entity.Student;
import com.panshi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;


    @GetMapping("/query")
    public List<Student> query() {
        return studentService.query();
    }

    @PostMapping("/insert")
    public Msg insert(@RequestBody Student student) {
        if (!"".equals(student.getName())&&0!=student.getAge()) {
            try {
                studentService.insert(student);
                return Msg.init(200, "新增成功", null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Msg.init(-200, "新增失败", null);
    }

    @GetMapping("/delete/{id}")
    public Msg delete(@PathVariable int id) {
        studentService.delete(id);
        return Msg.init(200, "删除成功", null);
    }

    @PostMapping("/update")
    public Msg update(@RequestBody Student student) {
        if (student != null) {
            try {
                studentService.update(student);
                return Msg.init(200, "修改成功", null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Msg.init(-200, "修改失败", null);
    }


}
