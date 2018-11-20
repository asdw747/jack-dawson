package com.jack.jackdawson.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Autowired
    private Environment env;

    @Bean(name = "myDataSource1")
    @Qualifier("myDataSource1")
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        return dataSource;
    }

    @Bean(name = "myDataSource2")
    @Qualifier("myDataSource2")
    @ConfigurationProperties(prefix="spring.datasource.back")
    public DataSource getMyDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(env.getProperty("spring.datasource.back.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.back.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.back.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.back.password"));
        return dataSource;
    }

}
