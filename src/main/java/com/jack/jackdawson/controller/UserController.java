package com.jack.jackdawson.controller;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.alibaba.fastjson.JSON;
import com.jack.jackdawson.biz.UserInfoBiz;
import com.jack.jackdawson.entity.jack.User;

@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserInfoBiz userInfoBiz;

    @GetMapping(value = "/test")
    @ResponseBody
    public String test(@RequestParam(required = false, defaultValue = "0") long userId){
        List<User> users = userInfoBiz.listByName("令狐冲");

        return "";
//        User user = userInfoBiz.getById(userId);
//        return user != null ? JSON.toJSONString(user) : "查无此人";
    }

}
