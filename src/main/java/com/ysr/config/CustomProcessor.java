package com.ysr.config;

import com.ysr.model.Student;
import org.springframework.batch.infrastructure.item.ItemProcessor;

public class CustomProcessor implements ItemProcessor<Student, Student> {

    @Override
    public Student process(Student student) throws Exception {
        // You can add any custom processing logic here if needed
        return student;
    }
}
