package com.graduate.loyee.controller.authApi;

import com.graduate.loyee.service.UserService;
import com.graduate.loyee.utils.common.Constant;
import com.graduate.loyee.utils.result.BaseResponseCode;
import com.graduate.loyee.utils.result.DataResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

//    @PostMapping("/login")
//    @ApiOperation(value = "用户登录接口")
//    public DataResult<LoginReturn> login(@RequestBody @Valid LoginReq loginUserVo){
//        DataResult<LoginReturn> result = DataResult.success();
//        try {
//            LoginReturn loginReturn = userOperationService.login(loginUserVo);
//            result.setData(loginReturn);
//        }catch(Exception e){
//            log.info(e.getMessage());
//            return DataResult.fail(-1,e.getMessage());
//        }
//        return result;
//    }
//
//    @PostMapping("/register")
//    @ApiOperation(value = "用户注册接口")
//    @ApiParam(name = "user",value = "用户对象")
//    public DataResult register(@RequestBody  @Valid User user , HttpServletRequest request){
//        DataResult<String> result=DataResult.success();
//        try {
//            User addUser = userOperationService.register(user);
//            result.setData(addUser.getId());
//        }catch(Exception e){
//            log.info(e.getMessage());
//            return DataResult.fail(-1,e.getMessage());
//        }
//        return result;
//    }

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
