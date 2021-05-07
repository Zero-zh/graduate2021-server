package com.graduate.loyee.service;

import com.graduate.loyee.entity.Competition;
import com.graduate.loyee.entity.ComprehensiveTest;
import com.graduate.loyee.mapper.CompetitionMapper;
import com.graduate.loyee.mapper.ComprehensiveTestMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ActivityService {
    @Autowired
    private ComprehensiveTestMapper comprehensiveTestMapper;

    @Autowired
    private CompetitionMapper competitionMapper;


    public List<ComprehensiveTest> getComprehensiveData(Integer beforeInt,Integer afterInt) {
        ComprehensiveTest comprehensiveTest = new ComprehensiveTest();
        comprehensiveTest.setStatus(0);

        Map<String,Object> parmMap = new HashMap<>();
        parmMap.put("ParmFROM",beforeInt);
        parmMap.put("ParmTO",afterInt);
        parmMap.put("status",0);
        List<ComprehensiveTest> comprehensiveTestList = comprehensiveTestMapper.getComprehensiveData(parmMap);
        return comprehensiveTestList;
    }

    public List<Competition> getCompetitionData() {
        Competition comprehensiveTest = new Competition();
        comprehensiveTest.setStatus(0);
        List<Competition> comprehensiveTestList = competitionMapper.getCompetitionData(comprehensiveTest);
        return comprehensiveTestList;
    }
}
