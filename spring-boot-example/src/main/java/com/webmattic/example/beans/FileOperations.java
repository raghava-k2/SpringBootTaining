package com.webmattic.example.beans;

import org.springframework.stereotype.Component;

@Component("fileOperations")
public class FileOperations {
    public void get() {
        System.out.println("Inside get");
    }
}
