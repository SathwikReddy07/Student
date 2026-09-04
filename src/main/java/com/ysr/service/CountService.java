package com.ysr.service;

import com.ysr.dto.Info;
import com.ysr.model.StudentCount;
import com.ysr.repo.ICountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountService implements ICountService{

    private ICountRepo countRepo;
    @Autowired
    public void setCountRepo (ICountRepo countRepo) {
        this.countRepo = countRepo;
    }

    @Override
    public String addNewBatch(Info info) {
        countRepo.save(new StudentCount(info.getBatch(), info.getBranch(), 0));
        return "Batch : " + info.getBatch() + " Branch : " + info.getBranch() + " has been added successfully";
    }

    @Override
    public StudentCount findById(Long id) {
        return countRepo.findById(id).orElse(null);
    }

    @Override
    public StudentCount findByBatchAndBranch(Info info) {
        return countRepo.findByBatchAndBranch(info.getBatch(), info.getBranch());
    }

    @Override
    public String addStudent(Info info) {
        StudentCount sc = countRepo.findByBatchAndBranch(info.getBatch(), info.getBranch());
        sc.setCount(sc.getCount() + 1);
        return "Student added successfully in Batch : " + info.getBatch() + " Branch : " + info.getBranch();
    }
}
