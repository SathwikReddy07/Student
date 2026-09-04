package com.ysr.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StudentCount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Batch batch;
    private Branch branch;
    private Integer count;

    public StudentCount() {}
    public StudentCount(Batch batch, Branch branch, Integer count) {
        this.batch = batch;
        this.branch = branch;
        this.count = count;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Batch getBatch() {
        return batch;
    }
    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public Branch getBranch() {
        return branch;
    }
    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Student Count { Id: " + id + ", Batch: " + batch + ", Branch: " + branch + ", Count: " + count + " }";
    }

}
