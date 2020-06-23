package com.jsondemo.service.implementors;

import com.jsondemo.exception.StudentException;
import com.jsondemo.exception.StudentException.ExceptionType;
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

    @Override
    public Student getStudentById(Integer id) throws StudentException {
        Student student = studentRepository.getStudentById(id);
        if (student == null){
            throw new StudentException(ExceptionType.STUDENT_NOT_FOUND);
        }
        return student;
    }

    @Override
    public void updateStudent(Integer id, Student student) throws IOException {
        studentRepository.updateStudent(id,student);
    }

    @Override
    public void deleteStudent(Integer id) throws IOException {
        studentRepository.deleteStudent(id);
    }
}
