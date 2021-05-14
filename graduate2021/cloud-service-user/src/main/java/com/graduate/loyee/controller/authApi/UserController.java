package com.graduate.loyee.controller.authApi;

import com.graduate.loyee.service.UserService;
import com.graduate.loyee.utils.common.Constant;
import com.graduate.loyee.utils.result.BaseResponseCode;
import com.graduate.loyee.utils.result.DataResult;
import com.graduate.loyee.vo.UserVo.ChangePasswordVo;
import com.graduate.loyee.vo.UserVo.UserInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/sys")
@Api(tags = "用户信息/操作")
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userOperationService;

    @GetMapping("/user/info")
    @ApiOperation(value = "获取用户信息")
    public DataResult<UserInfoVo> login(){
        DataResult<UserInfoVo> result = DataResult.success();
        try {
            UserInfoVo loginReturn = userOperationService.getUserInfo();
            result.setData(loginReturn);
        }catch(Exception e){
            log.info(e.getMessage());
            return DataResult.fail(-1,e.getMessage());
        }
        return result;
    }

    @PostMapping("/user/changeUserName")
    @ApiOperation(value = "更改昵称")
    public DataResult<String> changeUserName(String userName){
        DataResult<String> result = DataResult.success();
        try {
            userOperationService.changeUserName(userName);
            result.setData(userName);
        }catch(Exception e){
            log.info(e.getMessage());
            return DataResult.fail(-1,e.getMessage());
        }
        return result;
    }

    @GetMapping("/user/changePassword")
    @ApiOperation(value = "更改密码")
    public DataResult<String> changePassword(ChangePasswordVo para){
        DataResult<String> result = DataResult.success();
        try {
            userOperationService.changePassword(para);
            result.setData("删除成功");
        }catch(Exception e){
            log.info(e.getMessage());
            return DataResult.fail(-1,"原密码错误,请检查原密码");
        }
        return result;
    }

    @PostMapping("/logout")
    @ApiOperation(value = "登出接口")
    public DataResult logout(HttpServletRequest request){
        String accessToken=request.getHeader(Constant.ACCESS_TOKEN);
        if(accessToken == null){
            return DataResult.fail(BaseResponseCode.DATA_ERROR.getCode(), BaseResponseCode.DATA_ERROR.getMsg());
        }
        userOperationService.logout(accessToken);
        return DataResult.success();
    }



}
