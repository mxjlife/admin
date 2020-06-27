package com.mxjlife.admin.auth.pojo.auth;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * description 角色信息
 *
 * @author mxj
 * email mxjlife@163.com
 * date 2018/12/31 23:40
 */
@Data
public class SysRole {

    private Long id; // 编号
    private String name; // 角色名称
    private Integer level;  // 角色级别
    private String description; // 角色描述
    private Integer status; // 角色状态,1:可用, 2:不可用
    private String remark;  //备注
    private String createUser;  // 创建者
    private String updateUser;  // 更新者
    private Date createTime;  // 创建时间
    private Date updateTime;  // 更新时间

    private List<SysPermission> permissions;  //角色 -- 权限关系

}