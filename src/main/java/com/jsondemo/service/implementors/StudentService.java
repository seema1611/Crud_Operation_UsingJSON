package com.jsondemo.service.implementors;

import com.jsondemo.model.Student;
import com.jsondemo.repository.StudentRepository;
import com.jsondemo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) throws IOException {
        return studentRepository.createStudent(student);
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> studentList = studentRepository.getAllStudent();
        return studentList;
    }
}
