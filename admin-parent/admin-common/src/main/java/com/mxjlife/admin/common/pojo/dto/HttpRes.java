package com.mxjlife.admin.common.pojo.dto;

import com.mxjlife.admin.common.constant.SysCodeEnum;
import com.mxjlife.admin.common.exception.BaseException;
import lombok.Data;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * description 返回参数
 *
 * @author mxj
 * email mxjlife@163.com
 * date 2019/1/2 11:40
 */
@Data
public class HttpRes<T> {
    private Integer code;
    private String msg;
    private T data;

    private HttpRes() {
    }

    private HttpRes(SysCodeEnum codeEnum, T data) {
        this.code = codeEnum.getCode();
        this.msg = codeEnum.getMessage();
        if(data != null){
            this.data = data;
        }
    }

    private HttpRes(Integer code, String message, T data) {
        this.code = code;
        this.msg = message;
        if(data != null){
            this.data = data;
        }
    }

    /**
     * 构造一个自定义的返回结果
     *
     * @param code    状态码
     * @param msg 返回状态描述
     * @param data    返回数据
     * @return Response
     */
    public static <T> HttpRes<T> get(Integer code, String msg, T data) {
        return new HttpRes<>(code, msg, data);
    }

    /**
     * 获取一个没有业务数据的结果
     * @param code
     * @param msg
     * @return
     */
    public static HttpRes get(Integer code, String msg) {
        return new HttpRes<>(code, msg, null);
    }

    /**
     * 获取一个没有业务数据的结果
     */
    public static HttpRes get(SysCodeEnum codeEnum) {
        return new HttpRes<>(codeEnum.getCode(), codeEnum.getMessage(), null);
    }

    /**
     * 返回一个指定数据类型的数据
     */
    public static <T> HttpRes<T> get(SysCodeEnum codeEnum, Class<T> clazz) {
        return new HttpRes<>(codeEnum.getCode(), codeEnum.getMessage(), null);
    }

    /**
     * 将exception转为返回结果
     */
    public static HttpRes get(BaseException e) {
        return new HttpRes<>(e.getCode(), e.getMessage(), null);
    }

    /**
     * 获取一个成功结果
     */
    public static <T> HttpRes<T> getSuccess(T data) {
        return new HttpRes<>(SysCodeEnum.RESP_SUCCESS.getCode(), SysCodeEnum.RESP_SUCCESS.getMessage(), data);
    }

    /**
     * 获取一个成功结果
     */
    public static HttpRes getSuccess() {
        return new HttpRes<>(SysCodeEnum.RESP_SUCCESS.getCode(), SysCodeEnum.RESP_SUCCESS.getMessage(), null);
    }

}
