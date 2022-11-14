package com.gaman;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private Integer Id;
    private String name;
    private String address;
}
