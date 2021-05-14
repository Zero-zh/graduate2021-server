package com.graduate.loyee.entity;

import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Data;

import java.io.Serializable;
@Data
public class Experience implements Serializable {
    private String id;
    @DateTimeFormat("yyyy-MM-dd")
    private String time;

    private String title;

    private String author;

    private String type;

    private Integer views;

    private Integer status;

    private String link;

    private String desc;

    private static final long serialVersionUID = 1L;

}