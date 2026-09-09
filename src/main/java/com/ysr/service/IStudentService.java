package com.ysr.service;

import com.ysr.model.Batch;
import com.ysr.model.Branch;
import com.ysr.model.Student;

import java.util.List;

public interface IStudentService {

    String addStudent (Student student);

    String updateStudent (Student student);

    Student getStudentById (Long id);
    Student getStudentByRollNo (String rollNo);

    List<Student> getStudentByBatchAndBranch (Batch batch, Branch branch);
    List<Student> getStudentByBatch (Batch batch);
    List<Student> getStudentByBranch(Branch name);

}
