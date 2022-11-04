package com.webmattic.example.beans;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("fileOperations")
public class FileOperations implements InitializingBean {

    @Autowired
    private Environment env;

    @Value("${beans.enable.autoconfigure}")
    private Boolean autoConfigure;

    private static final String DBNAME;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Inside FileOperations afterPropertiesSet : ");
    }

    @PostConstruct
    public void setup() {
        System.out.println("Inside FileOperations postConstruct: ");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Inside FileOperations preDestroy: ");
    }

    public FileOperations() {
        System.out.println("Inside FileOperations Constructor: ");
    }

    static {
        System.out.println("Inside static block to initialize DBNAME : ");
        DBNAME = "mysql";
    }

    public void get() {
        System.out.println("Inside get : " + env.getProperty("beans.enable.autoconfigure"));
        System.out.println("Inside get autoConfigure : " + autoConfigure);
    }
}
