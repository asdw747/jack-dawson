package com.jack.jackdawson.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;

@Configuration
@PropertySource("classpath:config/redis.properties")
public class RedisConfig {

    @Autowired
    private Environment env;

    @Bean
    public Jedis getJedis() {
        return new Jedis(env.getProperty("spring.redis.host"), Integer.parseInt(env.getProperty("spring.redis.port")));
    }

}
