package com.graduate.loyee.controller.publicApi;

import com.graduate.loyee.entity.User;
import com.graduate.loyee.service.UserService;
import com.graduate.loyee.utils.result.DataResult;
import com.graduate.loyee.vo.UserVo.LoginReq;
import com.graduate.loyee.vo.UserVo.LoginReturn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RequestMapping("/sys")
@Api(tags = "用户信息/操作")
@RestController
@Slf4j
public class UserPublicController {

    @Autowired
    private UserService userOperationService;

    @PostMapping("/login")
    @ApiOperation(value = "用户登录接口")
    public DataResult<LoginReturn> login(@RequestBody @Valid LoginReq loginUserVo){
        DataResult<LoginReturn> result = DataResult.success();
        try {
            LoginReturn loginReturn = userOperationService.login(loginUserVo);
            result.setData(loginReturn);
        }catch(Exception e){
            log.info(e.getMessage());
            return DataResult.fail(-1,e.getMessage());
        }
        return result;
    }

    @PostMapping("/register")
    @ApiOperation(value = "用户注册接口")
    @ApiParam(name = "user",value = "用户对象")
    public DataResult register(@RequestBody  @Valid User user , HttpServletRequest request){
        DataResult<String> result=DataResult.success();
        try {
            User addUser = userOperationService.register(user);
            result.setData(addUser.getId());
        }catch(Exception e){
            log.info(e.getMessage());
            return DataResult.fail(-1,e.getMessage());
        }
        return result;
    }


    @PostMapping("/touristLogin")
    @ApiOperation(value = "游客登录接口")
    public DataResult<LoginReturn> touristLogin(){
        DataResult<LoginReturn> result = DataResult.success();
        try {
            LoginReturn loginReturn = userOperationService.touristLogin();
            result.setData(loginReturn);
        }catch(Exception e){
            log.info(e.getMessage());
            return DataResult.fail(-1,e.getMessage());
        }
        return result;
    }
//    @GetMapping("/user/info")
//    @ApiOperation(value = "获取用户信息")
//    public DataResult<LoginReturn> login(){
//        DataResult<LoginReturn> result = DataResult.success();
//        try {
//            LoginReturn loginReturn = userOperationService.getUserInfo();
//            result.setData(loginReturn);
//        }catch(Exception e){
//            log.info(e.getMessage());
//            return DataResult.fail(-1,e.getMessage());
//        }
//        return result;
//    }

}
