package com.codeseek.dbindices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class DbIndicesApplication {
    public static void main(String[] args) {
        SpringApplication.run(DbIndicesApplication.class, args);
    }
}
