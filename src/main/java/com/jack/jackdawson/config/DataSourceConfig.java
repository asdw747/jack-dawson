package com.jack.jackdawson.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import javax.sql.DataSource;

@Configuration
@ComponentScan(value = "com.jack.jackdawson")
public class DataSourceConfig implements EnvironmentAware {

    @Autowired
    private Environment env;

    @Override
    public void setEnvironment(Environment environment) {
        this.env = environment;
    }

    @Bean(name = "testMaster")
    @Qualifier("testSlave")
    @ConfigurationProperties(prefix="spring.datasource")
    public BasicDataSource getTestMaster(){
        DatabaseConnectionConfigurer configurer = getDatabaseConnectionConfigurer();
        String url = configurer.getValue("test_master_db_url");
        String username = configurer.getValue("test_master_db_username");
        String password = configurer.getValue("test_master_db_password");

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }

    @Bean(name = "jackMaster")
    @Qualifier("jackMaster")
    @ConfigurationProperties(prefix="spring.datasource.jack")
    public DataSource getMyDataSource2(){
        DatabaseConnectionConfigurer configurer = getDatabaseConnectionConfigurer();
        String url = configurer.getValue("jack_master_db_url");
        String username = configurer.getValue("jack_master_db_username");
        String password = configurer.getValue("jack_master_db_password");

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }

    @Bean
    public DatabaseConnectionConfigurer getDatabaseConnectionConfigurer() {
        DatabaseConnectionConfigurer connectionConfigurer = new DatabaseConnectionConfigurer();
        connectionConfigurer.setLocations(new ClassPathResource("config/db.properties"));
        String location = env.getProperty("location");
        if ("production".equals(env.getProperty("location")) || "staging".equals(env.getProperty("location"))) {
            connectionConfigurer.setKeyCryptor(new KeyCryptor());
        } else {
            connectionConfigurer.setKeyCryptor(new KeyCryptorFake());
        }

        return connectionConfigurer;
    }

}
