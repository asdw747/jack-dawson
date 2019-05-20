package com.jack.jackdawson.controller;

import com.alibaba.fastjson.JSON;
import com.jack.jackdawson.dao.jack.UserDAO;
import com.jack.jackdawson.entity.jack.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@Controller
@RequestMapping(value = "dao")
public class DaoController {

    @Resource(name = "myDataSource1")
    private DataSource myDataSource1;

    @Resource
    private UserDAO userDAO;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String index(){
        try {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(myDataSource1);
            List<?> resultList = jdbcTemplate.queryForList("select * from contract");
            System.out.println("===>>>>>>>>>>>" + JSON.toJSONString(resultList));

            List<User> users = userDAO.findAll();

            System.currentTimeMillis();
        } catch (Exception e) {
            System.currentTimeMillis();
        }

        return "Hello World!";
    }

}
