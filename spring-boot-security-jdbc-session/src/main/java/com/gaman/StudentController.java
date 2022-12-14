package com.gaman;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent() {
        return new Student(1, "test", "hyd");
    }

    @GetMapping("/student/id")
    public Student getStudentId() {
        return new Student(1212, "test", "hyd");
    }
}
