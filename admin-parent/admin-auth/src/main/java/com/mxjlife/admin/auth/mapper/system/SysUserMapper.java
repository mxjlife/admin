package com.mxjlife.admin.auth.mapper.system;

import com.mxjlife.admin.auth.pojo.auth.SysUserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * description: 用户信息表 数据库操作接口
 * email realmxj@163.com
 * @Sysor: mxj
 * date 2020-06-27 22:52:09
 * @version: V1.0
 */
@Mapper
public interface SysUserMapper {

    /**
     * 添加数据
     */
    int insert(SysUserInfo sysUser);

    /**
     * 使用主键 id 更新
     */
    int updateById(SysUserInfo sysUser);

    /**
     * 使用主键 id 查询
     */
    SysUserInfo selectById(@Param("id") Long id);

    /**
     * 查询总条数
     */
    long getTotalCount();

    /**
     * 分页按条件查询信息
     * 参数说明：
     *   startTime  按照时间段过滤开始时间
     *   endTime  按照时间段过滤结束时间
     *   offset  按页查询的开始索引
     *   pageSize 页大小
     */
    List<SysUserInfo> selectPageByParams(@Param("params") Map<String, Object> params);

    /**
     * 按条件查询信息条数
     * 参数说明：
     *   startTime  按照时间段过滤开始时间
     *   endTime  按照时间段过滤结束时间
     *   offset  按页查询的开始索引
     *   pageSize 页大小
     */
    long selectCountByParams(@Param("params") Map<String, Object> params);

    /**
     * 使用索引 uniq_username 查询数据
     */
      SysUserInfo selectByUsername(@Param("username") String username);



}
