package com.graduate.loyee.service;

import com.graduate.loyee.entity.Certificate;
import com.graduate.loyee.entity.EndExam;
import com.graduate.loyee.entity.NationalExam;
import com.graduate.loyee.mapper.CertificateMapper;
import com.graduate.loyee.mapper.EndExamMapper;
import com.graduate.loyee.mapper.NationalExamMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ExaminationService {
    @Autowired
    private EndExamMapper endExamMapper;

    @Autowired
    private CertificateMapper certificateMapper;

    @Autowired
    private NationalExamMapper nationalExamMapper;

    public List<EndExam> getEndExamData() {
        EndExam record = new EndExam();
        record.setStatus(0);
        List<EndExam> examData = endExamMapper.getEndExamData(record);
        return examData;
    }

    public List<Certificate> getCertificateData() {
        Certificate record = new Certificate();
        record.setStatus(0);
        List<Certificate> certificateData = certificateMapper.getCertificateData(record);
        return certificateData;
    }

    public List<NationalExam> getNationalExamData() {
        NationalExam record = new NationalExam();
        record.setStatus(0);
        List<NationalExam> nationalExamData = nationalExamMapper.getNationalExamData(record);
        return nationalExamData;
    }
}
