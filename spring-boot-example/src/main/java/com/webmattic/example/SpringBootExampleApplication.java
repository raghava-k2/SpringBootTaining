package com.webmattic.example;

import com.webmattic.example.beans.Sales;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = {"com.webmattic.org.example", "com.webmattic.example"})
public class SpringBootExampleApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext c = SpringApplication.run(SpringBootExampleApplication.class, args);
        Sales s = c.getBean("sales", Sales.class);
        s.print();
    }
}
