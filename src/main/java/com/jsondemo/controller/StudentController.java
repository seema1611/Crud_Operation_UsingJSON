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
    public Student createStudent(@RequestParam(value="id")int id,
                                 @RequestParam(value = "name") String name,
                                 @RequestParam(value="age") int age) throws IOException {
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        return studentService.createStudent(student);
    }

    @GetMapping("/allstudent")
    public List<Student> list() {
        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> get(@PathVariable Integer id) {
        try {
            Student student = studentService.get(id);
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        } catch (NoSuchElementException | StudentException e) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) throws IOException {
        studentService.deleteStudent(id);
    }
}
