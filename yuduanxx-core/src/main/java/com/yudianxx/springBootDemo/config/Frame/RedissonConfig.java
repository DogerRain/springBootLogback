package com.yudianxx.springBootDemo.config.Frame;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huangyongwen
 * @date 2020/10/15
 * @Description
 */
@Configuration
public class RedissonConfig {


    /**
     * redisson的配置 , 哨兵模式
     */
    @Bean
    public RedissonClient redissonClient() {
//        Config config = new Config();
//        config.useClusterServers()
//                .setScanInterval(2000)
//                .setPassword("redis")
//                .addNodeAddress("redis://81.71.16.134:6379","redis://81.71.16.134:6380")
//                .addNodeAddress("redis://81.71.16.134:6381");
//
//
//
//
//        RedissonClient redisson = Redisson.create(config);
//        return redisson;
        Config config = new Config();
//        config.useSingleServer();//单机
//        config.useMasterSlaveServers();//集群
//        config.useSentinelServers();//哨兵
//        config.useClusterServers();//集群

//        config.setLockWatchdogTimeout(30000);

        config.useMasterSlaveServers()
                .setPassword("redis")
                .setMasterAddress("redis://81.71.16.134:6379")
                .addSlaveAddress("redis://81.71.16.134:6380","redis://81.71.16.134:6381");

        return Redisson.create(config);

    }
/*
//    Jedis jedis = new Jedis("127.0.0.1", 6379);
//    private static final String LOCK_SUCCESS = "OK";
//    private static final Long UNLOCK_SUCCESS = 1L;

    *//**
     * 加锁
     *
     * @param key     锁标识
     * @param value   客户端标识
     * @param timeOut 过期时间
     * @return
     *//*
    public Boolean redicLock(String key, String value, Long timeOut) {
        // SET 操作成功 返回 "OK"
        String var1 = jedis.set(key, value, "NX", "PX", timeOut);

        if (LOCK_SUCCESS.equals(var1)) {
            return true;
        }
        return false;
    }

    public Boolean redisUnLock(String key, String value) {
        String luaScript = "if redis.call('get',KEYS[1]) == ARGV[1] then return redis.call('del',KEYS[1]) else  return 0 end";

        Object var2 = jedis.eval(luaScript, Collections.singletonList(key), Collections.singletonList(value));
        if (UNLOCK_SUCCESS == var2) {
            return true;
        }
        return false;
    }*/

}
