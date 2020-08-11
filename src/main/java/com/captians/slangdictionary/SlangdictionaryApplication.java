package com.captians.slangdictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SlangdictionaryApplication implements CommandLineRunner {

    @Autowired
    TestDataLoad testDataLoad;

    public static void main(String[] args) {
        SpringApplication.run(SlangdictionaryApplication.class, args);
    }

    @Override
    public void run(final String... s) {
        try{
            testDataLoad.loadJSON();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
