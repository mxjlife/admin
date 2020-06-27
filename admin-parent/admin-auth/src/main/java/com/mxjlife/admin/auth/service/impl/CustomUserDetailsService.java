package com.mxjlife.admin.auth.service.impl;

import com.mxjlife.admin.auth.mapper.system.SysPermissionMapper;
import com.mxjlife.admin.auth.mapper.system.SysRoleMapper;
import com.mxjlife.admin.auth.mapper.system.SysUserMapper;
import com.mxjlife.admin.auth.pojo.auth.SysPermission;
import com.mxjlife.admin.auth.pojo.auth.SysRole;
import com.mxjlife.admin.auth.pojo.auth.SysUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * description:
 * author mxj
 * email mengxiangjie@hualala.com
 * date 2020/6/26 22:40
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysRoleMapper roleMapper;

    @Autowired
    private SysPermissionMapper permissionMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUserInfo user = userMapper.selectByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("用户信息不存在 : " + username);
        }
        // TODO 用户是否锁定判断

        List<SysRole> roles = roleMapper.selectByUserId(user.getId());
        List<Long> roleIds = roles.stream()
                .map(SysRole::getId)
                .collect(Collectors.toList());
        List<SysPermission> permissions = permissionMapper.selectByRoleIdList(roleIds);
        return UserPrincipal.create(user, roles, permissions);
    }
}