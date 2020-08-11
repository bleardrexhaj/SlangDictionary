package com.captians.slangdictionary;

import com.captians.slangdictionary.dao.impl.TermDaoImpl;
import com.captians.slangdictionary.model.Term;
import com.captians.slangdictionary.service.TermService;
import com.captians.slangdictionary.service.impl.TermServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;

@Component
public class TestDataLoad {
    @Autowired
    TermService termService;

    @Value("classpath:testdata/hello.json")
    Resource resourceFile;

    @PostConstruct
    private void onStartup(){
        loadJSON();
    }

    public void loadJSON() {
        try{
            File file = resourceFile.getFile();
            String jsonString = new String(Files.readAllBytes(file.toPath()));

            ObjectMapper objectMapper = new ObjectMapper();
            List<Term> list = objectMapper.readValue(jsonString, new TypeReference<List<Term>>(){});
            for(Term t : list) {
                termService.addTerm(t);
            }
        }catch(Throwable t){
            t.printStackTrace();
        }

    }
}
