package com.graduate.loyee.vo.UserVo;

import lombok.Data;

@Data
public class ChangePasswordVo {

    private String beforePassword;

    private String afterPassword;

    private String confirmedPassword;
}
