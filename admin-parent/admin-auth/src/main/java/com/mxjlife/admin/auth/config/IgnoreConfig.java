package com.mxjlife.admin.auth.config;

import lombok.Data;
import org.apache.commons.compress.utils.Lists;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * description: 权限校验忽略的信息
 * author mxj
 * email mengxiangjie@hualala.com
 * date 2020/6/26 21:40
 */
@ConfigurationProperties(prefix = "auth.config.ignore")
@Data
public class IgnoreConfig {
    /**
     * 需要忽略的 URL 格式，不考虑请求方法
     */
    private List<String> pattern = Lists.newArrayList();

    /**
     * 需要忽略的 GET 请求
     */
    private List<String> get = Lists.newArrayList();

    /**
     * 需要忽略的 POST 请求
     */
    private List<String> post = Lists.newArrayList();

    /**
     * 需要忽略的 DELETE 请求
     */
    private List<String> delete = Lists.newArrayList();

    /**
     * 需要忽略的 PUT 请求
     */
    private List<String> put = Lists.newArrayList();

    /**
     * 需要忽略的 HEAD 请求
     */
    private List<String> head = Lists.newArrayList();

    /**
     * 需要忽略的 PATCH 请求
     */
    private List<String> patch = Lists.newArrayList();

    /**
     * 需要忽略的 OPTIONS 请求
     */
    private List<String> options = Lists.newArrayList();

    /**
     * 需要忽略的 TRACE 请求
     */
    private List<String> trace = Lists.newArrayList();
}