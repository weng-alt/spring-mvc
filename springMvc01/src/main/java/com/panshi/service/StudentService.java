package com.panshi.service;

import com.panshi.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> query();

    void insert(Student student);

    void delete(int id);

    void update(Student student);
}
