package com.panshi.mapper;

import com.panshi.entity.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> query();

    int insert(Student student);

    int delete(int id);

    int update(Student student);

}
