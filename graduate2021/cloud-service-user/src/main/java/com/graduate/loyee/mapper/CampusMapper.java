package com.graduate.loyee.mapper;

import com.graduate.loyee.entity.Campus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampusMapper {
    int deleteByPrimaryKey(String id);

    int insert(Campus record);

    int insertSelective(Campus record);

    Campus selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Campus record);

    int updateByPrimaryKey(Campus record);

    List<Campus> selectByCondition(Campus campus);

    List<Campus> selectHistoryData(Campus campus);

}