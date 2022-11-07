package com.webmattic.example.controller;

import com.webmattic.example.exceptions.ValidationException;
import com.webmattic.example.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/student/all")
    public List<Student> getStudentList() {
        return Arrays.asList(new Student(1, "test", "4", "A", 400, "hyderabad"));
    }

    @GetMapping("/student/{id}")
    public ResponseEntity getStudent(@PathVariable("id") Integer id) {
        if (id == 10) {
            return ResponseEntity.ok(new Student(10, "test10", "1", "B", 100, "Hyd"));
        }
       throw new ValidationException("Student record not found");
    }
}
