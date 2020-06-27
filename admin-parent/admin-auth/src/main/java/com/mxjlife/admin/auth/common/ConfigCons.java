package com.mxjlife.admin.auth.common;

/**
 * description: 系统配置用到的常量
 * author mxj
 * email mengxiangjie@hualala.com
 * date 2019/8/28 14:10
 */
public interface ConfigCons {

    // 数据库及mybatis相关配置
    String DS_DAO_PATH_SYS = "com.mxjlife.admin.auth.mapper.system";
    String DS_MAPPER_PATH_SYS = "classpath:mapper/system/*.xml";
    String DS_CONF_PRE_SYS = "spring.datasource.system";


}