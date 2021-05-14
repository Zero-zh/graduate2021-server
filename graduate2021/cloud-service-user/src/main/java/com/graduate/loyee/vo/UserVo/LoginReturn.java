package com.graduate.loyee.vo.UserVo;

import lombok.Data;

@Data
public class LoginReturn {
    private String token;
    private String username;
    private String id;
    private String accessToken;
}
