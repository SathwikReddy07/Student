package com.ysr.controller;

import com.ysr.dto.Info;
import com.ysr.service.ICountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/new")
public class CountController {

    private ICountService countService;
    @Autowired
    public void setCountService(ICountService countService) {
        this.countService = countService;
    }

    @PostMapping("/batch")
    public ResponseEntity<String> addNewBatch (@RequestBody Info info) {
        return new ResponseEntity<>(countService.addNewBatch(info), HttpStatus.CREATED);
    }

    @PatchMapping("/student")
    public ResponseEntity<String> addStudent(@RequestBody Info info) {
        return new ResponseEntity<>(countService.addStudent(info), HttpStatus.OK);
    }

}