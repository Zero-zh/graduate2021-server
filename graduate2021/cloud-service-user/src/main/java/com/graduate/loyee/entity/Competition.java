package com.graduate.loyee.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class Competition implements Serializable {
    private String id;

    private String date;

    private String activityName;

    private String location;

    private String sponsor;

    private String activityObject;

    private Integer status;

    private static final long serialVersionUID = 1L;
}