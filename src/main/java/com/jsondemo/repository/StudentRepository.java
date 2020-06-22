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

    public List<Student> loadData() {
        ObjectMapper mapper = new ObjectMapper();
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

    public Student createStudent(Student student) throws IOException {
        loadData();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("./src/main/resources/StudentDetails.json"),student);
        studentList.add(student);
        return student;
    }
}
