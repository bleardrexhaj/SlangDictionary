package com.captians.slangdictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath*:context/applicationContext.xml"})
public class SlangdictionaryApplication {

    @Autowired
    TestDataLoad testDataLoad;

    public static void main(String[] args) {
        SpringApplication.run(SlangdictionaryApplication.class, args);
    }
}
