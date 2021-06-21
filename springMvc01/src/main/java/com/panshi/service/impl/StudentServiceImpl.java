package com.panshi.service.impl;

import com.panshi.mapper.StudentMapper;
import com.panshi.pojo.Student;
import com.panshi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper dao;

    @Override
    public List<Student> test() {
        return dao.test();
    }
}
