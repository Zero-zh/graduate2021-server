package com.graduate.loyee.mapper;

import com.graduate.loyee.entity.Experience;
import com.graduate.loyee.vo.QAndAVo.QueryAskAnswerVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceMapper {
    int deleteByPrimaryKey(String id);

    int insert(Experience record);

    int insertSelective(Experience record);

    Experience selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Experience record);

    int updateByPrimaryKeyWithBLOBs(Experience record);

    int updateByPrimaryKey(Experience record);

    List<Experience> getWorkExperience(QueryAskAnswerVo para);
}