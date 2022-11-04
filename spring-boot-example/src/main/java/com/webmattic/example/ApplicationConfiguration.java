package com.webmattic.example;

import com.webmattic.example.beans.FileOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean("fileOperationsBean")
    public FileOperations fileOperations() {
        return new FileOperations();
    }
}
