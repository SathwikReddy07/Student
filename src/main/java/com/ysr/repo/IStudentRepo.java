package com.ysr.repo;

import com.ysr.model.Batch;
import com.ysr.model.Branch;
import com.ysr.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepo extends JpaRepository<Student, Long> {

    Student getStudentByRollNo(String rollNo);

    List<Student> getStudentByBatch(Batch batch);
    List<Student> getStudentByBranch(Branch branch);
    List<Student> getStudentByBatchAndBranch(Batch batch, Branch branch);

}
