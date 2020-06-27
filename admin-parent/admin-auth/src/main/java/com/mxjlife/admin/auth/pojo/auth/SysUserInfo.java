package com.mxjlife.admin.auth.pojo.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * description 用户信息
 * @author mxj
 * email mxjlife@163.com
 * date 2018/12/11 16:06
 */
@Data
public class SysUserInfo {

    /**
     * 用户编号
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 名称（昵称或者真实姓名，不同系统不同定义）
     */
    private String name;
    /**
     * 头像
     */
    private String head;
    /**
     * 密码
     */
    @JsonIgnore
    private String password;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 电话
     */
    private String phone;
    /**
     * 性别，男-1，女-2, 0-未知
     */
    private Integer sex;
    /**
     * 部门id
     */
    private Integer department;
    /**
     * 用户状态,0:创建未认证（没有激活）--等待验证的用户 , 1:正常状态,2：用户被锁定
     */
    private Integer status;
    /**
     * 备注信息
     */
    private String remark;
    /**
     * 创建者
     */
    private String createUser;
    /**
     * 更新者
     */
    private String updateUser;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 一个用户具有多个角色
     */
    private List<SysRole> roles;

}