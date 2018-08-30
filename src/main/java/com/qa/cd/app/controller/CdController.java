package com.qa.cd.app.controller;

import com.qa.cd.app.model.Cd;
import com.qa.cd.repository.CdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.logging.Logger;


@RestController
@RequestMapping("/cd")
public class CdController {

    private final Logger logger = Logger.getLogger(CdController.class.getName());

    @Autowired
    CdRepository cdRepository;
    //Create

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Cd cd){
        cdRepository.save(cd);
    }

    //Read
    @RequestMapping(value = "/{id}")
    public Cd read(@PathVariable Integer id){
        Optional<Cd> optCD = cdRepository.findById(id);
        if (optCD.isPresent()) {
            return optCD.get();
        } return null;
    }

    //Update
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Cd cd){
        cdRepository.save(cd);
    }

    //Delete
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id){
        cdRepository.deleteById(id);
    }
}
