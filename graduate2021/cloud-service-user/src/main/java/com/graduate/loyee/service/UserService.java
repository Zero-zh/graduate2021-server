package com.graduate.loyee.service;

import com.graduate.loyee.entity.User;
import com.graduate.loyee.mapper.UserMapper;
import com.graduate.loyee.utils.IdWorker.IdWorker;
import com.graduate.loyee.utils.jwt.JwtUtil;
import com.graduate.loyee.utils.jwt.PasswordUtils;
import com.graduate.loyee.utils.numberWorker.RandomEmail;
import com.graduate.loyee.utils.numberWorker.RandomString;
import com.graduate.loyee.utils.redis.RedisUtil;
import com.graduate.loyee.utils.result.BaseResponseCode;
import com.graduate.loyee.utils.result.BusinessException;
import com.graduate.loyee.vo.UserVo.ChangePasswordVo;
import com.graduate.loyee.vo.UserVo.LoginReq;
import com.graduate.loyee.vo.UserVo.LoginReturn;
import com.graduate.loyee.vo.UserVo.UserInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@Slf4j
public class UserService {

    private IdWorker idWorker = new IdWorker(0,0);



    @Autowired
    private UserMapper userMapper;


    public LoginReturn login(LoginReq vo) {
        log.info("帐号" + vo.getUsername());
        User userReq = new User();
        userReq.setAccountNumber(vo.getUsername());
        User sysUser = userMapper.selectByAccount(userReq);
        //无此账号
        if (null == sysUser) {
            throw new BusinessException(-1, "帐号或密码错误");
        }
        //密码错误
        String protoTypePassword = vo.getPassword();
        String password = sysUser.getPassword();
        String salt = sysUser.getSalt();
        if (!PasswordUtils.matches(salt, protoTypePassword,password)) {
            throw new BusinessException(-1, "帐号或密码错误");
        }
        //该账户已锁定
        if (sysUser.getStatus() == 1) {
            throw new BusinessException(BaseResponseCode.USER_LOCK);
        }
        LoginReturn respVo = new LoginReturn();
        respVo.setToken(sysUser.getAccountNumber()+"-"+sysUser.getUsername());
        respVo.setUsername(sysUser.getUsername());
        respVo.setId(sysUser.getId());
        respVo.setAccessToken(JwtUtil.sign(sysUser.getUsername(), sysUser.getPassword()));
        if(!StringUtils.isEmpty(RedisUtil.get("username")) || !StringUtils.isEmpty(RedisUtil.get("Id"))
            || !StringUtils.isEmpty(RedisUtil.get("token"))){
            RedisUtil.del("username");
            RedisUtil.del("Id");
            RedisUtil.del("token");
        }
        RedisUtil.setnx("username",respVo.getUsername());
        RedisUtil.setnx("Id",respVo.getId());
        RedisUtil.setnx("token",respVo.getAccessToken());
        return respVo;
    }

    public User register(User user) {
        User mysqlData = userMapper.selectByAccount(user);
        if(mysqlData != null){
            //该帐号已经注册
            throw new BusinessException(-1,"该帐号已经注册,请登录");
        }
        if(user.getPassword().length() < 6){
            throw new BusinessException(-1,"密码长度不能小于6位");
        }
        //将数据插入数据库
        user.setId(String.valueOf(idWorker.nextId()));
        user.setSalt(PasswordUtils.getSalt());
        user.setPassword(PasswordUtils.encode(user.getPassword(), user.getSalt()));
        userMapper.insert(user);
        return user;
    }

    public void logout(String accessToken) {
        if (StringUtils.isEmpty(accessToken)) {
            throw new BusinessException(BaseResponseCode.DATA_ERROR.getCode(),"退出失败,请先登录");
        }

        //前端清楚cookie,返回登录页面
    }

    public UserInfoVo getUserInfo() {
    //        token.split()
//        LoginReturn loginReturn = new LoginReturn();
//        loginReturn.setToken(RedisUtil.get("token").toString());
//        loginReturn.setId(RedisUtil.get("Id").toString());
//        loginReturn.setUsername(RedisUtil.get("username").toString());

        String userId = RedisUtil.get("Id").toString();
        User user = userMapper.selectByPrimaryKey(userId);
        UserInfoVo userInfoVo = new UserInfoVo();
        userInfoVo.setAccountNumber(user.getAccountNumber());
        userInfoVo.setUserName(user.getUsername());
        userInfoVo.setEmail(RandomEmail.getRandomString(userInfoVo.getAccountNumber()));
        return userInfoVo;
    }

    public LoginReturn touristLogin() {
        String acct = RandomString.getRandomString(11);
        User paraData = new User();
        paraData.setAccountNumber(acct);
        while(userMapper.selectByAccount(paraData) != null){
            acct = RandomString.getRandomString(11);
        }
        String passwordProtoType = "123456";
        String salt = PasswordUtils.getSalt();
        paraData.setPassword(passwordProtoType)
            .setSalt(salt)
            .setStatus(0)
            .setUsername(acct)
            .setId(idWorker.nextId()+"");
        User register = this.register(paraData);
        LoginReq loginReq = new LoginReq();
        loginReq.setUsername(paraData.getUsername());
        loginReq.setPassword(passwordProtoType);
        return this.login(loginReq);
    }



    public static void main(String[] args) {
//        String acct = "17820418132";
//        String password = "110120";
//        //判断密码对错
//        String salt = PasswordUtils.getSalt();
//        System.out.println(salt);
//        String encodePassword = PasswordUtils.encode(password,salt);
//        boolean matches = PasswordUtils.matches(salt, password, encodePassword);
//        System.out.println(matches);
//        System.out.println(encodePassword);
//        String token = JwtUtil.sign(acct, encodePassword);
//        System.out.println(token);
//        boolean bool = JwtUtil.verify(token, acct, encodePassword);
//        if(bool){
//            System.out.println("密码正确");
//        }else
//            System.out.println("密码错误");
        String userId = RedisUtil.get("id").toString();


    }

    public void changePassword(ChangePasswordVo para) throws Exception{
        //三者都不能为空
        if(para.getBeforePassword().equals(para.getAfterPassword())){
            //更改前后密码一致
            throw new Exception("更改前后密码不能一致");
        }else if(!para.getAfterPassword().equals(para.getConfirmedPassword())){
            //密码与确认密码不一致
            throw new Exception("密码与确认密码不一致");
        }
        //更改密码
        User user = new User();
//        user.setPassword(para.getConfirmedPassword());
        user.setId(RedisUtil.get("Id").toString());

        //判断原密码是否正确
        try{
            LoginReq loginReq = new LoginReq();
            String hadLoginUserName = RedisUtil.get("username").toString();
            User hadLogin = userMapper.selectByUserName(hadLoginUserName);
            loginReq.setUsername(hadLogin.getAccountNumber());
            loginReq.setPassword(para.getBeforePassword());
            this.login(loginReq);
        }catch (Exception e){
            throw new Exception("原密码错误,请检查原密码");
        }

        user.setSalt(PasswordUtils.getSalt());
        user.setPassword(PasswordUtils.encode(para.getConfirmedPassword(), user.getSalt()));
        int i = userMapper.updateByPrimaryKeySelective(user);
    }

    public void changeUserName(String userName) throws Exception{
        User user = new User();
        user.setUsername(userName);
        user.setId(RedisUtil.get("Id").toString());
        //更新数据库
        int i = userMapper.updateByPrimaryKeySelective(user);
        //更新Redis数据
        RedisUtil.del("username");
        RedisUtil.setnx("username",user.getUsername());
        if(i <= 0){
            throw new Exception("未知错误");
        }
    }
}
