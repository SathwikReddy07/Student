package com.ysr.service;

import com.ysr.dto.Info;
import com.ysr.dto.StuDto;
import com.ysr.model.Batch;
import com.ysr.model.Branch;
import com.ysr.model.Student;

import java.util.List;

public interface IStudentService {

    String addStudent (StuDto studentDto);

    String updateStudent (Student student);

    Student getStudentById (Long id);
    Student getStudentByRollNo (String rollNo);

    List<Student> getStudentByBatchAndBranch (Info info);
    List<Student> getStudentByBatch (Batch batch);
    List<Student> getStudentByBranch(Branch name);
    List<Student> getAll();

}
