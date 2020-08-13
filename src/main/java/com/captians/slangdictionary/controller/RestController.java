package com.captians.slangdictionary.controller;
import com.captians.slangdictionary.dao.TermDao;
import com.captians.slangdictionary.model.Term;
import com.captians.slangdictionary.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    TermDao repository;

    @GetMapping("/api")
    public @ResponseBody List<Term> getTermList(){
        return repository.findAll();
    }

    @GetMapping("/api/find")
    public @ResponseBody List<Term> getTermByWord(@RequestParam(value = "word") String word){
        System.out.println(word);
        List<Term> list = new ArrayList<>();
        for(Term t : repository.findAll()){
            if(t.getWord().equals(word)) list.add(t);
        }
        return list;
    }

    @PostMapping("/api")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addTerm(@RequestBody Term term) {
        System.out.println("/api/add");
        repository.save(term);
    }
}
