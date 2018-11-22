package com.jack.jackdawson.config;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JedisClusterFactory {

    private static JedisCluster cluster = null;

    public static JedisCluster getJedisCluster(List<String> clusterNodes) {
        if (cluster == null) {
            synchronized (JedisClusterFactory.class) {
                if (cluster == null) {
                    JedisPoolConfig poolConfig = new JedisPoolConfig();
                    poolConfig.setMaxTotal(50);
                    poolConfig.setMaxIdle(30);
                    poolConfig.setMinIdle(10);
                    poolConfig.setTestWhileIdle(false);
                    poolConfig.setTestOnReturn(false);

                    int socketTimeout = 1000;
                    int maxRedirections = 5;

                    Set<HostAndPort> jedisClusterNodes = new HashSet<>();
                    for (String node : clusterNodes) {
                        String[] hp = node.split(":");
                        HostAndPort hostAndPort = new HostAndPort(hp[0], Integer.valueOf(hp[1]));
                        jedisClusterNodes.add(hostAndPort);
                    }
                    cluster = new JedisCluster(jedisClusterNodes, socketTimeout, maxRedirections, poolConfig);
                }
            }
        }
        return cluster;
    }

}
