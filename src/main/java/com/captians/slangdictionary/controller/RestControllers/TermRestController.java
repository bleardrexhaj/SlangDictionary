package com.captians.slangdictionary.controller.RestControllers;

import com.captians.slangdictionary.dto.UserMessage;
import com.captians.slangdictionary.model.*;
import com.captians.slangdictionary.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class TermRestController {

    private final TermService repository;

    @Autowired
    public TermRestController(TermService repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public @ResponseBody List<Term> getTermList(){
        return repository.findAll();
    }

    @GetMapping("/term")
    public @ResponseBody List<Term> getTermByWord(@RequestParam(value = "word") String word){
        System.out.println(word);
        return repository.findAll().stream().filter(x->x.getWord().equalsIgnoreCase(word)).collect(Collectors.toList());
    }

    @PostMapping(value = "/addTerm")
    public @ResponseBody ResponseEntity<?> addTerm(@RequestBody Term term) throws Exception {
        UserMessage userMessage = new UserMessage();
        try {
            repository.addTerm(term);
        } catch (Exception e){
            throw new Exception(e.getMessage(), e);
        }
        userMessage.setMessage("Saving Term: Success!");
        userMessage.setHttpStatus(HttpStatus.OK);
        return new ResponseEntity<>(userMessage, HttpStatus.OK);
    }
}
