package com.ysr.repo;

import com.ysr.model.Batch;
import com.ysr.model.Branch;
import com.ysr.model.StudentCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountRepo extends JpaRepository<StudentCount, Long> {

    StudentCount findByBatchAndBranch(Batch batch, Branch branch);

}
