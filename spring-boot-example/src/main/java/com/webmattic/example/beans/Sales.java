package com.webmattic.example.beans;

import com.webmattic.org.example.beans.FileOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class Sales {

    @Autowired
    @Qualifier("fileOperations1")
    private FileOperations fileOperations;

    private com.webmattic.example.beans.FileOperations fileOperations1;

    private com.webmattic.example.beans.FileOperations fileOperations2;

    @Autowired
    @Qualifier("fileOperationsBean")
    private com.webmattic.example.beans.FileOperations fileOperations3;

    @Autowired
    Sales(com.webmattic.example.beans.FileOperations fileOperations) {
        this.fileOperations1 = fileOperations;
    }

    public com.webmattic.example.beans.FileOperations getFileOperations2() {
        return fileOperations2;
    }

    @Autowired
    @Qualifier("fileOperations")
    public void setFileOperations2(com.webmattic.example.beans.FileOperations fileOperations2) {
        this.fileOperations2 = fileOperations2;
    }

    public void print() {
        this.fileOperations.get();
        this.fileOperations1.get();
        this.fileOperations2.get();
    }
}
