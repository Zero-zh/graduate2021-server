package com.graduate.loyee.mapper;

import com.graduate.loyee.entity.ComprehensiveTest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ComprehensiveTestMapper {
    int deleteByPrimaryKey(String id);

    int insert(ComprehensiveTest record);

    int insertSelective(ComprehensiveTest record);

    ComprehensiveTest selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ComprehensiveTest record);

    int updateByPrimaryKey(ComprehensiveTest record);

    List<ComprehensiveTest> getComprehensiveData(Map<String,Object> parmMap);
}