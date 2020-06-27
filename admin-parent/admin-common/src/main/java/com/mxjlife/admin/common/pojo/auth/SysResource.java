package com.mxjlife.admin.common.pojo.auth;

import lombok.Data;

import java.util.Date;

/**
 * description 资源信息
 *
 * @author mxj
 * email mxjlife@163.com
 * date 2018/12/31 23:40
 */
@Data
public class SysResource {
    private int id;
    private String title;  //菜单标题
    private String name;  //资源名称
    private String type;//资源类型，[api|button]
    private String url;//资源路径.
    private int parentId; //父编号
    private String method;  //后端接口访问方式:get/post/put/delete
    private Integer sort;  //排序
    private String icon;  //图标
    private Integer status;  //状态, 1:正常, 2:不可用
    private String remark;  //备注
    private String createUser;  //创建者
    private String updateUser;  //更新者
    private Date updateTime;  //更新时间
    private Date createTime;  //创建时间

}