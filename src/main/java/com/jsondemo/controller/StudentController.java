package com.jsondemo.controller;

import com.jsondemo.model.Student;
import com.jsondemo.service.implementors.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public Student createStudent(@RequestParam(value="id")int id, @RequestParam(value = "name") String name, @RequestParam(value="age") int age) throws IOException {
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        return studentService.createStudent(student);
    }
}
