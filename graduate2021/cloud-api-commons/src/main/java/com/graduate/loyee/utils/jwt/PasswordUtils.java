package com.graduate.loyee.utils.jwt;


import java.util.UUID;

/**
 * @ClassName:       PasswordUtils
 *                   密码工具类
 * @Author:          HQ
 * @CreateDate:      2020/4/29 13:55
 * @UpdateUser:      HQ
 * @UpdateDate:      2020/4/29 13:55
 * @Version:         0.0.1
 */
public class PasswordUtils {

    /**
     * 匹配密码
     * @param salt 盐
     * @param rawPass 明文
     * @param encPass 密文
     * @return
     */
    public static boolean matches(String salt, String rawPass, String encPass) {
        return new PasswordEncoder(salt).matches(encPass, rawPass);
    }

    /**
     * 明文密码加密
     * @param rawPass 明文
     * @param salt
     * @return
     */
    public static String encode(String rawPass, String salt) {
        return new PasswordEncoder(salt).encode(rawPass);
    }

    /**
     * 获取加密盐
     * @return
     */
    //获取随机盐存到数据库用于密码校验
    public static String getSalt() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20);
    }
}

