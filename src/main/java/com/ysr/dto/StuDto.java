package com.ysr.dto;

import com.ysr.model.Batch;
import com.ysr.model.Branch;
import com.ysr.model.Gender;

public class StuDto {

    private String name;
    private String dob;
    private Gender gender;
    private String email;
    private String phone;
    private Batch batch;
    private Branch branch;

    public StuDto() {}
    public StuDto(String name, String dob, Gender gender, String email, String phone, Batch batch, Branch branch) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.batch = batch;
        this.branch = branch;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }

    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
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
    public String toString() {
        return "Student DTO { Name : " + name + " Dob : " + dob +
                " Gender : " + gender + " Email : " + email +
                " Phone : " + phone + " Batch : " + batch + " Branch : " + branch + " }";
    }

}
