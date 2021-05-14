package com.graduate.loyee.vo.UserVo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Data
public class LoginReq {
    @ApiModelProperty(value = "账号")
    @Valid
    @NotBlank(message = "账号不能为空")
    private String username;//用户名
    @ApiModelProperty(value = "密码")
    @Valid
    @NotBlank(message = "密码不能为空")
    private String password;//密码
}
