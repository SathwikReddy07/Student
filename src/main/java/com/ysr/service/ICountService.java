package com.ysr.service;

import com.ysr.dto.Info;
import com.ysr.model.Batch;
import com.ysr.model.Branch;
import com.ysr.model.StudentCount;

public interface ICountService {

    // Adds new column in the table
    String addNewBatch (Info info);

    // Returns the data by id
    StudentCount findById(Long id);

    // Returns the data by batch and branch
    StudentCount findByBatchAndBranch(Info info);

    // Increases Student Count
    void addStudent (Info info);


}
