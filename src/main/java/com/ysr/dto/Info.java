package com.ysr.dto;

import com.ysr.model.Batch;
import com.ysr.model.Branch;

public class Info {
    private Batch batch;
    private Branch branch;

    public Info(){}
    public Info(Batch batch, Branch branch){
        this.batch = batch;
        this.branch = branch;
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

    @Override
    public String toString(){
        return "Info { Batch : " + batch + ", Branch : " + branch + "}";
    }
}
