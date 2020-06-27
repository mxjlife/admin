package com.mxjlife.admin.common.exception;

import lombok.Data;

/**
 * description: 通用异常类
 * author mxj
 * email mengxiangjie@hualala.com
 * date 2020/6/26 20:01
 */
@Data
public class BaseException extends RuntimeException {
    private Integer code;
    private String message;
}
