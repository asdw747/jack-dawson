package com.jack.jackdawson.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@Configuration
@ComponentScan(value = "com.jack.jackdawson")
public class DataSourceConfig {

    @Autowired
    private Environment env;

    @Bean(name = "myDataSource1")
//    @Qualifier("myDataSource1")
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource getDataSource1(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUrl(env.getProperty("spring.datasource.url"));
//        dataSource.setUsername(env.getProperty("spring.datasource.username"));
//        dataSource.setPassword(env.getProperty("spring.datasource.password"));
//        return dataSource;

//        return new HikariDataSource();
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "myDataSource2")
//    @Qualifier("myDataSource2")
    @ConfigurationProperties(prefix="spring.datasource.jack")
    public DataSource getMyDataSource2(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUrl(env.getProperty("spring.datasource.back.url"));
//        dataSource.setUsername(env.getProperty("spring.datasource.back.username"));
//        dataSource.setPassword(env.getProperty("spring.datasource.back.password"));
//        return dataSource;

//        return new HikariDataSource();
        return DataSourceBuilder.create().build();
    }


}
