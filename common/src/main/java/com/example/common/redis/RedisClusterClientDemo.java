package com.example.common.redis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

public class RedisClusterClientDemo {

    private static final Set<HostAndPort> CLUSTER_NODES = new HashSet<>();

    static {
        CLUSTER_NODES.add(new HostAndPort("127.0.0.1", 6001));
        CLUSTER_NODES.add(new HostAndPort("127.0.0.1", 6002));
        CLUSTER_NODES.add(new HostAndPort("127.0.0.1", 6003));
        CLUSTER_NODES.add(new HostAndPort("127.0.0.1", 7001));
        CLUSTER_NODES.add(new HostAndPort("127.0.0.1", 7002));
        CLUSTER_NODES.add(new HostAndPort("127.0.0.1", 7003));
    }

    public static void main(String[] args) {
        try (JedisCluster cluster = new JedisCluster(CLUSTER_NODES)) {
            System.out.println("集群实例数量：" + cluster.getClusterNodes().size());

            cluster.set("cluster:demo", "yyds");
            System.out.println("cluster:demo = " + cluster.get("cluster:demo"));
        }
    }
}