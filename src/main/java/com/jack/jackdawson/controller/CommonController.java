package com.jack.jackdawson.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@RestController
@EnableAutoConfiguration
public class CommonController {

    @Resource(name = "myDataSource1")
    private DataSource myDataSource1;

    @RequestMapping("/hello")
    private String index(){
        try {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(myDataSource1);
            List<?> resultList = jdbcTemplate.queryForList("select * from contract");
            System.out.println("===>>>>>>>>>>>" + JSON.toJSONString(resultList));

            System.currentTimeMillis();
        } catch (Exception e) {
            System.currentTimeMillis();
        }

        return "Hello World!";
    }

    @RequestMapping(value = "/testGet", method = RequestMethod.GET)
    public String testGet(@RequestParam long userId){
        return userId + "ok";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CommonController.class, args);
    }


}
