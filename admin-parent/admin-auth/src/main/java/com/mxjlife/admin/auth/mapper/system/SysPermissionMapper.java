package com.mxjlife.admin.auth.mapper.system;

import com.mxjlife.admin.auth.pojo.auth.SysPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * description: 资源信息表 数据库操作接口
 * email realmxj@163.com
 * @Sysor: mxj
 * date 2020-06-27 22:52:08
 * @version: V1.0
 */
@Mapper
public interface SysPermissionMapper {

    /**
     * 添加数据
     */
    int insert(SysPermission sysPermission);

    /**
     * 使用主键 id 更新
     */
    int updateById(SysPermission sysPermission);

    /**
     * 使用主键 id 查询
     */
    SysPermission selectById(@Param("id") Long id);

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
    List<SysPermission> selectPageByParams(@Param("params") Map<String, Object> params);

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
     * 使用索引 idx_name 查询数据
     */
    List<SysPermission> selectByName(@Param("name") String name);

    /**
     * 查询多个角色的权限信息
     * @param roleIds
     */
    List<SysPermission> selectByRoleIdList(@Param("roleIds")List<Long> roleIds);
}
