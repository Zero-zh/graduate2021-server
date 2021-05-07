package com.graduate.loyee.mapper;

import com.graduate.loyee.entity.NationalExam;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NationalExamMapper {
    int deleteByPrimaryKey(String id);

    int insert(NationalExam record);

    int insertSelective(NationalExam record);

    NationalExam selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(NationalExam record);

    int updateByPrimaryKey(NationalExam record);

    List<NationalExam> getNationalExamData(NationalExam record);
}