package com.graduate.loyee.mapper;

import com.graduate.loyee.entity.Certificate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificateMapper {
    int deleteByPrimaryKey(String id);

    int insert(Certificate record);

    int insertSelective(Certificate record);

    Certificate selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Certificate record);

    int updateByPrimaryKey(Certificate record);

    List<Certificate> getCertificateData(Certificate record);

}