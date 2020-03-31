package com.jack.jackdawson.controller;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.Optional;
import com.alibaba.fastjson.JSON;
import com.jack.jackdawson.entity.jack.User;
import com.jack.jackdawson.repository.jack.UserDAO;

@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserDAO userDAO;

    @GetMapping(value = "/test")
    @ResponseBody
    public String test(@RequestParam(required = false, defaultValue = "0") long userId){
        Optional<User> userOptional = userDAO.findById(1L);
        return userOptional.map(JSON::toJSONString).orElse("null");
    }

}
