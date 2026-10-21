package com.example.common.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RedisSentinelClientDemo {

    private static final String MASTER_NAME = "lbwnb";
    private static final Set<String> SENTINELS = new HashSet<>(Arrays.asList(
            "127.0.0.1:26739",
            "127.0.0.1:26740",
            "127.0.0.1:26741"
    ));

    public static void main(String[] args) {
        try (JedisSentinelPool pool = new JedisSentinelPool(MASTER_NAME, SENTINELS)) {
            try (Jedis jedis = pool.getResource()) {
                jedis.set("sentinel:test", "114514");
                System.out.println("write to master: " + pool.getCurrentHostMaster());
            }

            try (Jedis jedis = pool.getResource()) {
                System.out.println("sentinel:test = " + jedis.get("sentinel:test"));
                System.out.println("read from master: " + pool.getCurrentHostMaster());
            }
        }
    }
}