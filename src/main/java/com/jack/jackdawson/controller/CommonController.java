package com.jack.jackdawson.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class CommonController {

    @Resource(name = "myDataSource1")
    private DataSource myDataSource1;

    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    @ResponseBody
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

    @RequestMapping(value = "/testGet", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    @ResponseBody
    public String testGet(@RequestParam long userId){
        return userId + "ok";
    }

    @RequestMapping(value = "/testVM", method = RequestMethod.GET)
    public String testVM(){
        return "index";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CommonController.class, args);
    }


}
