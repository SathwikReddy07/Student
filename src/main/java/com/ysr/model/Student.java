package com.ysr.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDate createdAt;
    private String name;
    private String dob;
    private Gender gender;
    private String email;
    private String phone;
    private Batch batch;
    private Branch branch;
    private String rollNo;

    public Student() {}
    public Student(String name, String dob, Gender gender, String email, String phone, Batch batch, Branch branch, String rollNo) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.batch = batch;
        this.branch = branch;
        this.rollNo = rollNo;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
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

    public String getRollNo() {
        return rollNo;
    }
    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", createdAt=" + createdAt + ", name=" + name
                + ", dob=" + dob + ", gender=" + gender + ", email=" + email + ", phone=" + phone
                + ", batch=" + batch + ", branch=" + branch + ", rollNo=" + rollNo + "]";
    }

}