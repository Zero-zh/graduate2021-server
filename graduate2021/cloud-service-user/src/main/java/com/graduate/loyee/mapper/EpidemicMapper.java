package com.graduate.loyee.mapper;

import com.graduate.loyee.entity.Epidemic;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EpidemicMapper {
    int deleteByPrimaryKey(String id);

    int insert(Epidemic record);

    int insertSelective(Epidemic record);

    Epidemic selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Epidemic record);

    int updateByPrimaryKey(Epidemic record);

    List<Epidemic> getEpidemicData(Epidemic parm);
}