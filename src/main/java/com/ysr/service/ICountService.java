package com.ysr.service;

import com.ysr.dto.Info;
import com.ysr.model.Batch;
import com.ysr.model.Branch;
import com.ysr.model.StudentCount;

import java.util.List;

public interface ICountService {

    // Adds new column in the table
    // All batch and branch combinations are already added in the table.
    String addNewBatch (Info info);

    // Returns the data by id
    StudentCount findById(Long id);

    // Returns the data by batch and branch
    StudentCount findByBatchAndBranch(Info info);

    // Increases Student Count
    void addStudent (Info info);

    // Returns the branches and the count of students in particular branch
    List<StudentCount> findByBatch(Batch batch);

    // Returns the batches and the count of students in particular branch
    List<StudentCount> findByBranch(Branch branch);


}
