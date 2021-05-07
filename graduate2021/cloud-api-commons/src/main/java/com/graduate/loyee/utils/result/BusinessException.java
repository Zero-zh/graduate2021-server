package com.graduate.loyee.utils.result;

/**
 * @ClassName: BusinessException
 * @Author: HQ
 * @CreateDate: 2020/4/29 18:02
 * @UpdateUser: HQ
 * @UpdateDate: 2020/4/29 18:02
 * @Version: 0.0.1
 */
public class BusinessException extends RuntimeException{
    /**
     * 异常编号
     */
    private final int messageCode;

    /**
     * 对messageCode 异常信息进行补充说明
     */
    private final String detailMessage;

    public BusinessException(int messageCode,String message) {
        super(message);
        this.messageCode = messageCode;
        this.detailMessage = message;
    }
    /**
     * 构造函数
     * @param code 异常码
     */
    public BusinessException(ResponseCodeInterface code) {
        this(code.getCode(), code.getMsg());
    }

    public int getMessageCode() {
        return messageCode;
    }

    public String getDetailMessage() {
        return detailMessage;
    }
}
