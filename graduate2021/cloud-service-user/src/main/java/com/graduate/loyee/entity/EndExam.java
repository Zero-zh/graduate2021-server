package com.graduate.loyee.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class EndExam implements Serializable {
    private String id;

    private String time;

    private String name;

    private String location;

    private String sponer;

    private String examObject;

    private Integer status;

    private static final long serialVersionUID = 1L;

}