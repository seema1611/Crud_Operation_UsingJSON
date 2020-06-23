package com.jsondemo.repository;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsondemo.model.Student;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.List;

@Repository
public class StudentRepository {
    private List<Student> studentList;
    ObjectMapper mapper= new ObjectMapper();;

    public List<Student> loadData() {
        try {
            InputStream inputStream = new FileInputStream(new File("./src/main/resources/StudentDetails.json"));
            TypeReference<List<Student>> typeReference = new TypeReference<List<Student>>() {};
            studentList = mapper.readValue(inputStream, typeReference);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    public void writeDataInJson() {
        try {
            mapper.writeValue(new File("./src/main/resources/StudentDetails.json"),studentList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Student createStudent(Student student) throws IOException {
        loadData();
        studentList.add(student);
        writeDataInJson();
        return student;
    }

    public List<Student> getAllStudent() {
        loadData();
        return studentList;
    }

    public Student getStudentById(Integer id) {
        loadData();
        for(Student s: studentList) {
            if( s.getId() == id )
                return s;
        }
        return null;
    }

    public void updateStudent(Integer id, Student student) throws IOException {
        Student studentById = getStudentById(id);
        studentById.setName((student.getName() == null) ? studentById.getName(): student.getName() );
        studentById.setAge((student.getAge() == 0) ? studentById.getAge(): student.getAge() );
        studentList.set(studentList.indexOf(studentById), studentById);
        writeDataInJson();
    }

    public void deleteStudent(Integer id) throws IOException {
        loadData();
        Student deleteStudent = null;
        for (Student s : studentList) {
            if (s.getId() == id)
                deleteStudent  = s;
        }
        if (deleteStudent  != null) {
            studentList.remove(deleteStudent);
        }
        writeDataInJson();
    }
}
