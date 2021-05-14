package com.graduate.loyee.utils.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName: DataResult

 * @Author: HQ
 * @CreateDate: 2020/4/29 13:48
 * @UpdateUser: HQ
 * @UpdateDate: 2020/4/29 13:48
 * @Version: 0.0.1
 */
@Data
@Accessors(chain = true)
public class DataResult <T> implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 请求响应code，0为成功 其他为失败
     */
    @ApiModelProperty(value = "请求响应code，0为成功 其他为失败", name = "code")
    private int code;

    /**
     * 响应异常码详细信息
     */
    @ApiModelProperty(value = "响应异常码详细信息", name = "message")
    private String message;


    /**
     * 响应内容 ， code 0 时为 返回 数据
     */
    @ApiModelProperty(value = "需要返回的数据", name = "data")
    private T data;


    public DataResult(int code, T data) {
        this.code = code;
        this.data = data;
        this.message=null;
    }


    public DataResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public DataResult(int code, String message) {
        this.code = code;
        this.message = message;
        this.data=null;
    }


    public DataResult() {
        this.code=BaseResponseCode.SUCCESS.getCode();
        this.message=BaseResponseCode.SUCCESS.getMsg();
        this.data=null;
    }

    public DataResult(T data) {
        this.data = data;
        this.code=BaseResponseCode.SUCCESS.getCode();
        this.message=BaseResponseCode.SUCCESS.getMsg();
    }


    public DataResult(ResponseCodeInterface responseCodeInterface) {
        this.data = null;
        this.code = responseCodeInterface.getCode();
        this.message = responseCodeInterface.getMsg();
    }

    public DataResult(ResponseCodeInterface responseCodeInterface, T data) {
        this.data = data;
        this.code = responseCodeInterface.getCode();
        this.message = responseCodeInterface.getMsg();
    }
    /**
     * 操作成功 data为null
     * @Author:      HQ
     * @CreateDate:  2020/4/29 13:48
     * @UpdateUser:
     * @UpdateDate:  2020/4/29 13:48
     * @Version:     0.0.1
     * @param
     * @return       com.xh.lesson.utils.DataResult<T>
     * @throws
     */
    public static <T>DataResult success(){
        return new <T>DataResult();
    }

    /**
     * 操作失败 data为null
     * @Author:      HQ
     * @CreateDate:  2020/4/29 13:48
     * @UpdateUser:
     * @UpdateDate:  2020/4/29 13:48
     * @Version:     0.0.1
     * @param
     * @return       com.xh.lesson.utils.DataResult<T>
     * @throws
     */
    public static <T>DataResult fail(int code , String message){
        return new <T>DataResult(code,message);
    }

    /**
     * 操作失败 data为null
     * @Author:      HQ
     * @CreateDate:  2020/4/29 13:48
     * @UpdateUser:
     * @UpdateDate:  2020/4/29 13:48
     * @Version:     0.0.1
     * @param
     * @return       com.xh.lesson.utils.DataResult<T>
     * @throws
     */
    public static <T>DataResult fail(T data){
        return new <T>DataResult(data);
    }
    /**
     * 操作成功 data 不为null
     * @Author:      HQ
     * @CreateDate:  2020/4/29 13:48
     * @UpdateUser:
     * @UpdateDate:  2020/4/29 13:48
     * @Version:     0.0.1
     * @param data
     * @return       com.xh.lesson.utils.DataResult<T>
     * @throws
     */
    public static <T>DataResult success(T data){
        return new <T>DataResult(data);
    }


    /**
     * 自定义 返回操作 data 可控
     * @Author:      HQ
     * @CreateDate:  2020/4/29 13:48
     * @UpdateUser:
     * @UpdateDate:  2020/4/29 13:48
     * @Version:     0.0.1
     * @param code
     * @param message
     * @param data
     * @return       com.xh.lesson.utils.DataResult
     * @throws
     */
    public static <T>DataResult getResult(int code,String message,T data){
        return new <T>DataResult(code,message,data);
    }
    /**
     *  自定义返回  data为null
     * @Author:      HQ
     * @CreateDate:  2020/4/29 13:48
     * @UpdateUser:
     * @UpdateDate:  2020/4/29 13:48
     * @Version:     0.0.1
     * @param code
     * @param message
     * @return       com.xh.lesson.utils.DataResult
     * @throws
     */
    public static <T>DataResult getResult(int code,String message){
        return new <T>DataResult(code,message);
    }
    /**
     * 自定义返回 入参一般是异常code枚举 data为空
     * @Author:      HQ
     * @CreateDate:  2020/4/29 13:48
     * @UpdateUser:
     * @UpdateDate:  2020/4/29 13:48
     * @Version:     0.0.1
     * @param responseCode
     * @return       com.xh.lesson.utils.DataResult
     * @throws
     */
    public static <T>DataResult getResult(BaseResponseCode responseCode){
        return new <T>DataResult(responseCode);
    }
    /**
     * 自定义返回 入参一般是异常code枚举 data 可控
     * @Author:      HQ
     * @CreateDate:  2020/4/29 13:48
     * @UpdateUser:
     * @UpdateDate:  2020/4/29 13:48
     * @Version:     0.0.1
     * @param responseCode
     * @param data
     * @return       com.xh.lesson.utils.DataResult
     * @throws
     */
    public static <T>DataResult getResult(BaseResponseCode responseCode,T data){

        return new <T>DataResult(responseCode,data);
    }
}

