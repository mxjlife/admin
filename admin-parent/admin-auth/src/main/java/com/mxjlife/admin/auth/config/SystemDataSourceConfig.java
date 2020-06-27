package com.mxjlife.admin.auth.config;

import com.mxjlife.admin.auth.common.ConfigCons;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
/**
 * description 系统数据库所使用的数据源
 *
 * @author mxj
 * email mxjlife@163.com
 * date 2018/11/28 22:11
 */
@Slf4j
@Configuration
@MapperScan(basePackages = ConfigCons.DS_DAO_PATH_SYS, sqlSessionTemplateRef = "orderSqlSessionTemplate")
public class SystemDataSourceConfig {

    private static final String DS_DAO_PATH_ORDER = "";


    @Bean(name = "orderHikariConfig")
    @ConfigurationProperties(prefix = ConfigCons.DS_CONF_PRE_SYS)
    public HikariConfig orderHikariConfig() {
        return new HikariConfig();
    }

    @Bean(name = "orderDS")
    public DataSource orderDataSource(@Qualifier("orderHikariConfig") HikariConfig hikariConfig) {
        return new HikariDataSource(hikariConfig);
    }

    @Bean(name = "orderSqlSessionFactory")
    public SqlSessionFactory orderSqlSessionFactory(@Qualifier("orderDS") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(ConfigCons.DS_MAPPER_PATH_SYS));
        return bean.getObject();
    }

    @Bean(name = "orderTransactionManager")
    public DataSourceTransactionManager orderTransactionManager(@Qualifier("orderDS") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "orderSqlSessionTemplate")
    public SqlSessionTemplate orderSqlSessionTemplate(@Qualifier("orderSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        if(log.isDebugEnabled()){
            log.debug("DataSource [{}] initialize success !!!", "order");
        }
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}