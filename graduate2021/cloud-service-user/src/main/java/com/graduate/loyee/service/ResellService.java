package com.graduate.loyee.service;

import com.graduate.loyee.entity.Transaction;
import com.graduate.loyee.mapper.TransactionMapper;
import com.graduate.loyee.vo.ResellVo.SelectTransByConditionVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ResellService {

    @Autowired
    private TransactionMapper transactionMapper;

    public List<Transaction> getResellData() {
        Transaction transaction = new Transaction();
        transaction.setStatus(0);
        List<Transaction>transactionList = transactionMapper.getResellData(transaction);
        return transactionList;
    }

    public List<Transaction> selectByCondition(SelectTransByConditionVo para) {
        List<Transaction> transactionList = transactionMapper.selectByCondition(para);
        return transactionList;
    }
}
