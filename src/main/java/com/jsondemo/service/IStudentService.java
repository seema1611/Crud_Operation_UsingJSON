package com.jsondemo.service;

import com.jsondemo.model.Student;

import java.io.IOException;

public interface IStudentService {
    Student createStudent(Student student) throws IOException;
}
