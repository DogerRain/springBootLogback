package com.yudianxx.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RedisTest {
    public static void main(String[] args) {
        Set<String> sentinels = new HashSet<>();
        sentinels.add("192.168.0.174:26379");
        sentinels.add("192.168.0.174:26380");
        sentinels.add("192.168.0.174:26381");
        JedisSentinelPool pool = new JedisSentinelPool("mymaster", sentinels);
        int i = 0;

        while (true) {
            Jedis jedis = new Jedis();
            try {
                jedis = pool.getResource();
                String ip = jedis.getClient().getHost();
                int port = jedis.getClient().getPort();

                String key = "k-" + new Random().nextInt(1000);
                String value = "v-" + new Random().nextInt(1000);
                jedis.set(key, value);
//
//              JedisPoolConfig config = new JedisPoolConfig();
//              config =new JedisPoolConfig();
//              config.setMaxTotal(100);//设置最大连接数
//              config.setMaxIdle(50); //设置最大空闲数
//              config.setMinIdle(1);
//              config.setMaxWaitMillis(3000);//设置超时时间
//              config.setTestOnBorrow(true);

                System.out.println("当前主库：" + ip + ":" + port + ",key:" + key + ",value:" + jedis.get(key));

                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (jedis != null) {
                    jedis.close();
                    i++;
                }
            }

        }
    }
}
