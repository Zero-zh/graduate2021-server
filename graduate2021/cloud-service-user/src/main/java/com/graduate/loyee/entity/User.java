package com.graduate.loyee.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Data
@Accessors(chain = true)
public class User implements Serializable {
    private String id;

    private String accountNumber;

    private String salt;

    private String password;

    private String username;

    private Integer status;

    private static final long serialVersionUID = 1L;
}