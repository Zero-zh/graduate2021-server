package com.graduate.loyee.mapper;

import com.graduate.loyee.entity.Competition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetitionMapper {
    int deleteByPrimaryKey(String id);

    int insert(Competition record);

    int insertSelective(Competition record);

    Competition selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Competition record);

    int updateByPrimaryKey(Competition record);

    List<Competition> getCompetitionData(Competition comprehensiveTest);
}