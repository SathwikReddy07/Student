package com.ysr.config;

import com.ysr.model.Student;
import com.ysr.repo.IStudentRepo;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.infrastructure.item.data.RepositoryItemWriter;
import org.springframework.batch.infrastructure.item.file.FlatFileItemReader;
import org.springframework.batch.infrastructure.item.file.LineMapper;
import org.springframework.batch.infrastructure.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.infrastructure.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.infrastructure.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfig {

    private IStudentRepo studentRepo;
    @Autowired
    public void setStudentRepo(IStudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    private PlatformTransactionManager transactionManager;
    @Autowired
    public void  setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    private JobRepository jobRepository;
    @Autowired
    public void setJobRepository(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    private LineMapper<Student> lineMapper() {
        DefaultLineMapper<Student> mapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setDelimiter(",");
        tokenizer.setStrict(false);
        tokenizer.setNames("name", "dob", "gender", "email", "phone", "batch", "branch", "rollNo");
        BeanWrapperFieldSetMapper<Student> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Student.class);
        mapper.setLineTokenizer(tokenizer);
        mapper.setFieldSetMapper(fieldSetMapper);
        return mapper;
    }

    @Bean
    public FlatFileItemReader<Student> itemReader() {
        FlatFileItemReader<Student> reader = new FlatFileItemReader<>(lineMapper());
        reader.setResource(new FileSystemResource("src/main/resources/students_data.csv"));
        reader.setName("CSV-Reader");
        reader.setLinesToSkip(1);
        return reader;
    }

    @Bean
    public CustomProcessor processor() {
        return new CustomProcessor();
    }

    @Bean
    public RepositoryItemWriter<Student> itemWriter() {
        RepositoryItemWriter<Student> writer = new RepositoryItemWriter<Student>(studentRepo);
        writer.setMethodName("save");
        return writer;
    }

    public Step step() {
        return new StepBuilder("step",jobRepository)
                .<Student, Student>chunk(100)
                .transactionManager(transactionManager)
                .reader(itemReader())
                .processor(processor())
                .writer(itemWriter())
                .build();
    }

    @Bean
    public Job job () {
        return new JobBuilder("job", jobRepository)
                .start(step())
                .build();
    }

}
