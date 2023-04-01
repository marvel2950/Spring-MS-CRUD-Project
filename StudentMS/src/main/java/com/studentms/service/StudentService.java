package com.studentms.service;

import com.studentms.model.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface StudentService {

    public List<Student> getAllStudent();

    public Student createStudent(Student student);

    public ResponseEntity<Student> getStudentById(Long id) ;

    public ResponseEntity<Student> updateStudent(Long id,Student studentDetails) ;

    public ResponseEntity<Map<String, Boolean>> deleteStudent(Long id);

    public String  helloStudent();

}