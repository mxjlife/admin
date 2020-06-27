package com.mxjlife.admin.auth.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jwt.config")
@Data
public class JwtConfig {
    /**
     * jwt 加密 key，
     */
    private String key = "mxjlife";

    /**
     * jwt 过期时间，默认值：1800000 {@code 10 分钟}.
     */
    private Long ttl = 1800000L;

    /**
     * 开启 记住我 之后 jwt 过期时间，默认值 604800000 {@code 7 天}
     */
    private Long remember = 604800000L;
}