package com.jack.jackdawson.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "redis")
public class RedisController {
    private static final Logger logger = LoggerFactory.getLogger(RedisController.class);

    @Resource
    private Jedis jedis;

    @GetMapping(value = "/check")
    @ResponseBody
    public String test(){
        try {
            String key = "testJedis";
            jedis.setex(key, 10, "ok");
            String value = jedis.get(key);

            logger.debug("redis is ok.");
            return "redis is ok";
        } catch (Exception e) {
            logger.info("redis query error.", e);
            return "redis error";
        }
    }


}
