package com.graduate.loyee.utils.result;


public enum BaseResponseCode implements ResponseCodeInterface {
    SUCCESS(0,"操作成功"),
    SYSTEM_BUSY(500001, "系统繁忙，请稍候再试"),
    OPERATION_ERRO(500002,"操作失败"),
    NO_DATA(500003,"无此数据"),
    TOKEN_PARSE_ERROR(401001, "登录凭证已过期，请重新登录"),
    TOKEN_ERROR(401001, "登录凭证已过期，请重新登录"),
    ACCOUNT_ERROR(401001, "该账号异常，请联系运营人员"),
    ACCOUNT_LOCK_ERROR(401001, "该用户已被锁定，请联系运营人员"),
    TOKEN_PAST_DUE(401002, "授权信息已过期，请刷新token"),
    DATA_ERROR(401003,"传入数据异常"),
    NOT_ACCOUNT(401004, "该用户不存在,请先注册"),
    USER_LOCK(401005, "该用户已被锁定，请联系系统管理员"),
    PASSWORD_ERROR(401006,"用户名或密码错误"),
    METHODARGUMENTNOTVALIDEXCEPTION(401007, "方法参数校验异常"),
    UNAUTHORIZED_ERROR(401008, "无操作权限"),
    ROLE_PERMISSION_RELATION(401009, "该菜单权限存在子集关联，不允许删除"),
    OLD_PASSWORD_ERROR(401010,"旧密码不正确"),
    UN_AUTH(401011,"用户禁止授权"),
    HAS_ACCOUNT(401012, "该账号已存在，请联系运营人员"),
    HAS_ROLE(401013, "该角色已存在，请联系运营人员"),
    HAS_LABEL_NAME(401014,"标签名称已存在"),
    UPLOAD_ERROR(401015,"文件上传异常"),
    UPLOAD_FAIL(401016,"文件上传失败"),
    FILE_NOT_FIND(401017,"文件不存在"),
    PARSE_DATE(600001,"日期转换异常")
    ;

    /**
     * 错误码
     */
    private final int code;
    /**
     * 错误消息
     */
    private final String msg;

    BaseResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}

