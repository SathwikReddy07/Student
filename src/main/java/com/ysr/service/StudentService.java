package com.ysr.service;

import com.ysr.dto.Info;
import com.ysr.dto.StuDto;
import com.ysr.model.Batch;
import com.ysr.model.Branch;
import com.ysr.model.Student;
import com.ysr.repo.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    private IStudentRepo studentRepo;
    @Autowired
    public void setStudentRepo(IStudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public String addStudent(StuDto studentDto) {
        Student student = new Student(studentDto.getName(), studentDto.getDob(), studentDto.getGender(),
                studentDto.getEmail(), studentDto.getPhone(), studentDto.getBatch(), studentDto.getBranch(), null);
        studentRepo.save(student);
        return student.getName() + " is successfully added in batch" + student.getBatch() + " branch " +  student.getBranch();
    }

    @Override
    public String updateStudent(Student student) {
        studentRepo.save(student);
        return student.getName() + " is successfully updated.";
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepo.findById(id).orElse(null);
    }

    @Override
    public Student getStudentByRollNo(String rollNo) {
        return studentRepo.getStudentByRollNo(rollNo);
    }

    @Override
    public List<Student> getStudentByBatchAndBranch(Info info) {
        return studentRepo.getStudentByBatchAndBranch(info.getBatch(), info.getBranch());
    }

    @Override
    public List<Student> getStudentByBatch(Batch batch) {
        return studentRepo.getStudentByBatch(batch);
    }

    @Override
    public List<Student> getStudentByBranch(Branch branch) {
        return studentRepo.getStudentByBranch(branch);
    }
}
