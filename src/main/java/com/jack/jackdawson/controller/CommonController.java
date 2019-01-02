package com.jack.jackdawson.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@Controller
@RequestMapping(value = "")
public class CommonController {

    @Resource(name = "myDataSource1")
    private DataSource myDataSource1;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String index(){
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

}
