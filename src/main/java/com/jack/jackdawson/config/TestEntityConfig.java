//package com.jack.jackdawson.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.annotation.Resource;
//import javax.sql.DataSource;
//import java.util.HashMap;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        basePackages= {"com.jack.jackdawson.repository.test"}, //设置Repository所在位置
//        entityManagerFactoryRef="testEntityManager",
//        transactionManagerRef="testTransactionManager"
//)
//public class TestEntityConfig {
//
//    @Resource(name = "myDataSource1")
//    private DataSource primaryDataSource;
//
//    @Bean("testEntityManager")
//    @Primary
//    public LocalContainerEntityManagerFactoryBean testEntityManager() {
//        LocalContainerEntityManagerFactoryBean em
//                = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(primaryDataSource);
//        em.setPackagesToScan(
//                new String[] { "com.jack.jackdawson.entity.test" });
//
//        HibernateJpaVendorAdapter vendorAdapter
//                = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//        HashMap<String, Object> properties = new HashMap<>();
////        properties.put("hibernate.hbm2ddl.auto",
////                env.getProperty("hibernate.hbm2ddl.auto"));
////        properties.put("hibernate.dialect",
////                env.getProperty("hibernate.dialect"));
//        em.setJpaPropertyMap(properties);
//
//        return em;
//    }
//
//    @Bean("testTransactionManager")
//    @Primary
//    public PlatformTransactionManager testTransactionManager() {
//
//        JpaTransactionManager transactionManager
//                = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(
//                testEntityManager().getObject());
//        return transactionManager;
//    }
//
//}
