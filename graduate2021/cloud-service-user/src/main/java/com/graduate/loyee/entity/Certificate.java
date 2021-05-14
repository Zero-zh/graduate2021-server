package com.graduate.loyee.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class Certificate implements Serializable {
    private String id;

    private String time;

    private String name;

    private String location;

    private String sponner;

    private String object;

    private Integer status;

    private static final long serialVersionUID = 1L;

}