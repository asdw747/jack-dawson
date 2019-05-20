package com.jack.jackdawson.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "dao")
public class DaoController {
    private static final Logger logger = LoggerFactory.getLogger(DaoController.class);

//    @Resource(name = "myDataSource1")
//    private DataSource myDataSource1;
//
//    @Resource
//    private UserDAO userDAO;
//
//    @RequestMapping(value = "/check", method = RequestMethod.GET)
//    @ResponseBody
//    public String check(){
//        try {
//            JdbcTemplate jdbcTemplate = new JdbcTemplate(myDataSource1);
//            List<?> resultList = jdbcTemplate.queryForList("select * from contract");
//            System.out.println("===>>>>>>>>>>>" + JSON.toJSONString(resultList));
//
//            List<User> users = userDAO.findAll();
//
//            return "dao source is ok";
//        } catch (Exception e) {
//            logger.error("dao query error.", e);
//            return "dao source error";
//        }
//    }

}
