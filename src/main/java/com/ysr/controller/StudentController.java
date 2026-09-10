package com.ysr.controller;

import com.ysr.dto.Info;
import com.ysr.dto.StuDto;
import com.ysr.model.Batch;
import com.ysr.model.Branch;
import com.ysr.model.Student;
import com.ysr.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private IStudentService studentService;
    @Autowired
    public void setStudentService(IStudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addStudent(@RequestBody StuDto stuDto) {
        return new  ResponseEntity<>(studentService.addStudent(stuDto), HttpStatus.CREATED);
    }

    @PatchMapping("/update")
    public ResponseEntity<String> updateStudent(@RequestBody Student student) {
        return new  ResponseEntity<>(studentService.updateStudent(student), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudentById (@PathVariable Long id) {
        return new  ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @GetMapping("/get/roll/{rollNo}")
    public ResponseEntity<Student> getStudentByRollNo(@PathVariable String rollNo) {
        return new  ResponseEntity<>(studentService.getStudentByRollNo(rollNo), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Student>> getStudentByBatchAndBranch(@RequestParam Batch batch, @RequestParam Branch branch) {
        return new  ResponseEntity<>(studentService.getStudentByBatchAndBranch(new Info(batch, branch)), HttpStatus.OK);
    }

    @GetMapping("/get/batch/{batch}")
    public ResponseEntity<List<Student>> getStudentByBatch(@PathVariable Batch batch) {
        return new  ResponseEntity<>(studentService.getStudentByBatch(batch), HttpStatus.OK);
    }

    @GetMapping("/get/branch/{branch}")
    public ResponseEntity<List<Student>> getStudentByBranch(@PathVariable Branch branch) {
        return new  ResponseEntity<>(studentService.getStudentByBranch(branch), HttpStatus.OK);
    }

}
