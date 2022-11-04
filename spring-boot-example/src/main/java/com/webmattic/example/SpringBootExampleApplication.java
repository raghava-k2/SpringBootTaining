package com.webmattic.example;

import com.webmattic.example.beans.Sales;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages = {"com.webmattic.org.example", "com.webmattic.example"})
@PropertySource("file:D:\\workspace\\example.properties")//change the path according to location which you have saved the file
public class SpringBootExampleApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext c = SpringApplication.run(SpringBootExampleApplication.class, args);
        Sales s = c.getBean("sales", Sales.class);
        s.print();
    }
}
