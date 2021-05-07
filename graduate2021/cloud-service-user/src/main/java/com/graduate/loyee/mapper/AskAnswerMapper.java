package com.graduate.loyee.mapper;

import com.graduate.loyee.entity.AskAnswer;
import com.graduate.loyee.vo.QAndAVo.QueryAskAnswerVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AskAnswerMapper {
    int deleteByPrimaryKey(String id);

    int insert(AskAnswer record);

    int insertSelective(AskAnswer record);

    AskAnswer selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AskAnswer record);

    int updateByPrimaryKeyWithBLOBs(AskAnswer record);

    int updateByPrimaryKey(AskAnswer record);

    List<AskAnswer> getAskAndAnswerData(QueryAskAnswerVo askAnswer);

    Integer selectRowCount(QueryAskAnswerVo para);

    List<AskAnswer> selectByCondition(AskAnswer question);
}