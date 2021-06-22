package com.panshi.service.impl;

import com.panshi.entity.Student;
import com.panshi.mapper.StudentMapper;
import com.panshi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public List<Student> query() {
        return studentMapper.query();
    }

    public void insert(Student student) {
        studentMapper.insert(student);
    }

    public void delete(int id) {
        studentMapper.delete(id);
    }

    public void update(Student student) {
        studentMapper.update(student);
    }
}
