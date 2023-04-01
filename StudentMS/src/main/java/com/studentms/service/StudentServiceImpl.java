package com.studentms.service;

import com.studentms.client.APIClient;
import com.studentms.exception.ResourceNotFoundException;
import com.studentms.exception.StudentNotFoundException;
import com.studentms.model.Student;
import com.studentms.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    private APIClient apiClient;


    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public ResponseEntity<Student> getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("No student exist with id :" + id));
        return ResponseEntity.ok(student);
    }

    public ResponseEntity<Student> updateStudent(Long id,Student studentDetails) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("No student exist with id :" + id));

        student.setFirstName(studentDetails.getFirstName());
        student.setLastName(studentDetails.getLastName());
        student.setEmailId(studentDetails.getEmailId());
        student.setPhoneNum(studentDetails.getPhoneNum());

        Student updatedStudent = studentRepository.save(student);
        return ResponseEntity.ok(updatedStudent);
    }

    public ResponseEntity<Map<String, Boolean>> deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("No student exist with id :" + id));

        studentRepository.delete(student);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted successfully", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    public String  helloStudent(){
        try{
            return apiClient.helloWorld();
        }
        catch(Exception e){
            throw new ResourceNotFoundException("Hello MS is not available, Please try again later !");
        }

    }
}