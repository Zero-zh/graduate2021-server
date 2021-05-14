package com.graduate.loyee.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
@Data
public class Transaction implements Serializable {
    private String id;

    private String title;

    private BigDecimal priceBefore;

    private BigDecimal price;

    private String author;

    private Integer views;

    private Integer status;

    private String pic;

    private static final long serialVersionUID = 1L;


}