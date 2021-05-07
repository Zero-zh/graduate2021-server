package com.graduate.loyee.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class NationalExam implements Serializable {
    private String id;

    private String time;

    private String title;

    private String content;

    private String sponner;

    private String object;

    private Integer status;

    private static final long serialVersionUID = 1L;

}