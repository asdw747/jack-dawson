package com.jack.jackdawson.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;
import com.alibaba.fastjson.JSON;
import com.jack.jackdawson.biz.UserInfoBiz;
import com.jack.jackdawson.entity.jack.User;
import com.jack.jackdawson.model.enums.UserType;

@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

    @Resource
    private UserInfoBiz userInfoBiz;

    @GetMapping(value = "/test")
    @ResponseBody
    public String test(@RequestParam(required = false, defaultValue = "0") long userId){

        log.info("aaaaaa");
        UserType userType1 = UserType.NORMAL;
        UserType userType2 = UserType.NORMAL;

        List<String> extraInfos = userType1.getExtraInfos();
        extraInfos.sort(Comparator.comparing(o -> o));

        List<String> e = userType2.getExtraInfos();

        User user = userInfoBiz.getById(userId);
        return user != null ? JSON.toJSONString(user) : "查无此人";
    }

}
