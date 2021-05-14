package com.graduate.loyee.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ComprehensiveTest implements Serializable {
    private String id;

    private String title;

    private String time;

    private String img;

    private Integer clicks;

    private Integer status;

    private static final long serialVersionUID = 1L;

}