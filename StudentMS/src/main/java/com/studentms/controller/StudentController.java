package com.studentms.controller;

import com.studentms.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public interface StudentController {

    //Get all students data
    public List<Student> getAllStudent();

    //Create a new student entry
    public Student createStudent(@RequestBody Student student);

    //Get student data by id
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) ;

    //Update student data using id as key
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) ;

    //Delete student data using id as key
    public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable Long id);

    public String  helloStudent();
}