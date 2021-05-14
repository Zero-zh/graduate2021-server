package com.graduate.loyee.mapper;

import com.graduate.loyee.entity.Transaction;
import com.graduate.loyee.vo.ResellVo.SelectDataByMysql;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionMapper {
    int deleteByPrimaryKey(String id);

    int insert(Transaction record);

    int insertSelective(Transaction record);

    Transaction selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Transaction record);

    int updateByPrimaryKey(Transaction record);

    List<Transaction> getResellData(Transaction transaction);

    List<Transaction> selectByCondition(SelectDataByMysql para);
}