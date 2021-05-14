package com.graduate.loyee.service;

import com.graduate.loyee.entity.Transaction;
import com.graduate.loyee.mapper.TransactionMapper;
import com.graduate.loyee.vo.ResellVo.SelectDataByMysql;
import com.graduate.loyee.vo.ResellVo.SelectTransByConditionVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
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
        SelectDataByMysql selectDataByMysql = new SelectDataByMysql();
        if(!StringUtils.isEmpty(para.getPriceMin())){
            selectDataByMysql.setPriceMin(new BigDecimal(para.getPriceMin()));
        }else{
            selectDataByMysql.setPriceMin(new BigDecimal("0"));
        }
        if(!StringUtils.isEmpty(para.getPriceMax())){
            selectDataByMysql.setPriceMax(new BigDecimal(para.getPriceMax()));
        }else{
            selectDataByMysql.setPriceMax(new BigDecimal("99999"));
        }
        selectDataByMysql.setContent(para.getContent());
        List<Transaction> transactionList = transactionMapper.selectByCondition(selectDataByMysql);
        return transactionList;
    }
}
