package com.studentms.controller;

import java.util.List;
import java.util.Map;

import com.studentms.model.Student;
import com.studentms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class StudentControllerImpl implements StudentController {

    @Autowired
    private StudentService studentService;

    //Get all students data
    @GetMapping("/studentms/students")
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    //Create a new student entry
    @PostMapping("/studentms/student")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    //Get student data by id
    @GetMapping("/studentms/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    //Update student data using id as key
    @PutMapping("/studentms/student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        return studentService.updateStudent(id,studentDetails);
    }

    //Delete student data using id as key
    @DeleteMapping("/studentms/student/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }

    @GetMapping("/studentms/hellostudent")
    public String helloStudent() {
        return studentService.helloStudent();
    }

}