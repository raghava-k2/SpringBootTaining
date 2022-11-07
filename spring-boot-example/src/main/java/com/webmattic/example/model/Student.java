package com.webmattic.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {

    private Integer id;
    private String name;
    private String className;
    private String section;
    private Integer totalMarks;
    private String address;
}
