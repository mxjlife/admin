package com.mxjlife.admin.common.pojo.system;

import lombok.Data;

import java.util.Date;

/**
 * description
 *
 * @author mxj
 * email mxjlife@163.com
 * date 2019/1/2 11:06
 */
@Data
public class SysAccessLog {

    private int id;  //主键
    private String username;  //用户
    private String ip;  //用户ip
    private String uri;  //请求的uri地址
    private String params;  //请求的参数
    private Integer result;  //操作的结果,1成功,2失败,3系统异常
    private String remarks;  //备注信息
    private Date createTime;  //创建时间


}
