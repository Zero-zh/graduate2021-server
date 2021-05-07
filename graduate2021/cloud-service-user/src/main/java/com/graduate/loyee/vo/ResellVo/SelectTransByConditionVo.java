package com.graduate.loyee.vo.ResellVo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SelectTransByConditionVo {
    private BigDecimal priceMin;

    private BigDecimal priceMax;

    private String content;
}
