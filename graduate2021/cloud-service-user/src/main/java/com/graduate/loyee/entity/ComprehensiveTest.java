package com.graduate.loyee.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class ComprehensiveTest implements Serializable {
    private String id;

    private String title;

    private String time;

    private String img;

    private Integer clicks;

    private Integer status;

    private static final long serialVersionUID = 1L;

}