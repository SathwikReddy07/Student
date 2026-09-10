package com.ysr.controller;

import com.ysr.dto.Info;
import com.ysr.model.Batch;
import com.ysr.model.Branch;
import com.ysr.model.StudentCount;
import com.ysr.service.ICountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class CountController {

    private ICountService countService;
    @Autowired
    public void setCountService(ICountService countService) {
        this.countService = countService;
    }

    @GetMapping("/get")
    public ResponseEntity<StudentCount> findByBatchAndBranch(@RequestParam Batch batch, @RequestParam Branch branch) {
        return ResponseEntity.ok(countService.findByBatchAndBranch(new Info(batch, branch)));
    }

    @GetMapping("/get/batch/{batch}")
    public ResponseEntity<List<StudentCount>> findByBatch(@PathVariable Batch batch) {
        return ResponseEntity.ok(countService.findByBatch(batch));
    }

    @GetMapping("/get/branch/{branch}")
    public ResponseEntity<List<StudentCount>> findByBranch(@PathVariable Branch branch) {
        return ResponseEntity.ok(countService.findByBranch(branch));
    }

}
