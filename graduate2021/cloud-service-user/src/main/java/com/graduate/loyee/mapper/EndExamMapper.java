package com.graduate.loyee.mapper;

import com.graduate.loyee.entity.EndExam;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EndExamMapper {
    int deleteByPrimaryKey(String id);

    int insert(EndExam record);

    int insertSelective(EndExam record);

    EndExam selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(EndExam record);

    int updateByPrimaryKey(EndExam record);

    List<EndExam> getEndExamData(EndExam record);
}