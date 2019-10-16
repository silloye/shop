package cn.mall.shop.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.datasource.druid")
@Getter
@Setter
public class DruidDataSourceProperties {

    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private int maxActive;
    private int initialSize;
    private int maxWait;
    private int minIdle;
    private String validationQuery;
    private String filters;
    private long timeBetweenEvictionRunsMillis;
    private long minEvictableIdleTimeMillis;
    private Boolean poolPreparedStatements;
    private int maxOpenPreparedStatements;
    private int maxPoolPreparedStatementPerConnectionSize;

}
