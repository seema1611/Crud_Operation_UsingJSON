package com.jsondemo.service;

import com.jsondemo.exception.StudentException;
import com.jsondemo.model.Student;

import java.io.IOException;
import java.util.List;

public interface IStudentService {
    Student createStudent(Student student) throws IOException;
    List<Student> getAllStudent();
    Student getStudent(Integer id) throws StudentException;
    void updateStudent(Integer id, Student student);
    void deleteStudent(Integer id) throws IOException;
}
