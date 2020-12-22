package com.jack.jackdawson.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.jack.jackdawson.entity.jack.Privilege;
import com.jack.jackdawson.repository.jack.PrivilegeDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("privilege")
public class PrivilegeController {

    @Autowired
    private PrivilegeDAO privilegeDAO;

    @GetMapping(value = "/list")
    @ResponseBody
    public String list(){
        log.info("list all privilege");
        List<Privilege> privileges = privilegeDAO.findAll();
        log.info("list result {}", privileges);

        return JSON.toJSONString(privileges, SerializerFeature.WriteDateUseDateFormat);
    }

}
