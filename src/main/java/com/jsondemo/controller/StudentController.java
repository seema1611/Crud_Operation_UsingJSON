package com.jsondemo.controller;

import com.jsondemo.exception.StudentException;
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
    public Student createStudent(@RequestBody Student student) throws IOException {
        return studentService.createStudent(student);
    }

    @GetMapping("/allstudent")
    public List<Student> list() {
        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Integer id) {
        try {
            Student student = studentService.getStudent(id);
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        } catch (NoSuchElementException | StudentException e) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updatestudent/{id}")
    public void updateStudent(@PathVariable Integer id,@RequestBody Student student ) throws IOException {
        studentService.updateStudent(id,student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) throws IOException {
        studentService.deleteStudent(id);
    }
}
