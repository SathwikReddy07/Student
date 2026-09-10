package com.ysr.service;

import com.ysr.dto.Info;
import com.ysr.repo.ICountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RollNum {

    private CountService countService;
    @Autowired
    public void setCountService(CountService countService) {
        this.countService = countService;
    }
    private ICountRepo countRepo;
    @Autowired
    public void setCountRepo(ICountRepo countRepo) {
        this.countRepo = countRepo;
    }

    public String rollCreation (Info info) {
        StringBuilder sb = new StringBuilder();
        switch (info.getBatch()) {
            case BATCH_22 -> sb.append("22");
            case BATCH_23 -> sb.append("23");
            case BATCH_24 -> sb.append("24");
            case BATCH_25 -> sb.append("25");
            case BATCH_26 -> sb.append("26");
            case BATCH_27 -> sb.append("27");
        }
        switch (info.getBranch()) {
            case CS -> sb.append("CS");
            case CM -> sb.append("CM");
            case CD -> sb.append("CD");
            case CC -> sb.append("CC");
            case EC -> sb.append("EC");
            case EE -> sb.append("EE");
            case CI -> sb.append("CI");
            case ME -> sb.append("ME");
        }
        countService.addStudent(info);
        int i = countRepo.findByBatchAndBranch(info.getBatch(), info.getBranch()).getCount();
        sb.append(i);
        return sb.toString();
    }

}
