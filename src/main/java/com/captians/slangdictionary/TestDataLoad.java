package com.captians.slangdictionary;

import com.captians.slangdictionary.dao.impl.TermDaoImpl;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;

@Component
public class TestDataLoad {
    @Autowired
    TermDaoImpl termDao;

    @Value("classpath:testdata/hello.json")
    Resource resourceFile;

    public void loadJSON() throws Throwable {
        System.out.println();
        File file = resourceFile.getFile();
        String jsonString = new String(Files.readAllBytes(file.toPath()));
        JSONParser parser = new JSONParser(jsonString);
        System.out.println(parser.parseArray());
    }
}
