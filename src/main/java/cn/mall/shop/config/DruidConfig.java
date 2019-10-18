package cn.mall.shop.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DruidConfig {

//    @Autowired
//    @Qualifier("myDruidProperties")
//    private DruidDataSourceProperties properties;

//    @Bean
////    @ConditionalOnMissingBean
//    @Primary
//    public DataSource druidDataSource() {
//        DruidDataSource druidDataSource;
//        try {
//            //将我们自己定义的配置信息注入的DruidDataSource的对象中
//            druidDataSource = new DruidDataSource();
//            druidDataSource.setDriverClassName(properties.getDriverClassName());
//            druidDataSource.setUrl(properties.getUrl());
//            druidDataSource.setUsername(properties.getUsername());
//            druidDataSource.setPassword(properties.getPassword());
//            druidDataSource.setMaxActive(properties.getMaxActive());
//            druidDataSource.setInitialSize(properties.getInitialSize());
//            druidDataSource.setMaxWait(properties.getMaxWait());
//            druidDataSource.setMinIdle(properties.getMinIdle());
//            druidDataSource.setValidationQuery(properties.getValidationQuery());
//            druidDataSource.setFilters(properties.getFilters());
//            druidDataSource.setTimeBetweenEvictionRunsMillis(properties.getTimeBetweenEvictionRunsMillis());
//            druidDataSource.setMinEvictableIdleTimeMillis(properties.getMinEvictableIdleTimeMillis());
//            druidDataSource.setPoolPreparedStatements(properties.getPoolPreparedStatements());
//            druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(properties.getMaxPoolPreparedStatementPerConnectionSize());
//            druidDataSource.setMaxOpenPreparedStatements(properties.getMaxOpenPreparedStatements());
//            druidDataSource.init();
//            return druidDataSource;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.druid")
    public DataSource druidDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

}
