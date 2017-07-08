package org.demo.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by wangl on 2017/5/3.
 */
public class JedisUtil {

    private static String host = "127.0.0.1";
    private static int prot = 6379;
    private static String auth = "wangl";
    //jedis的连接池
    private static JedisPool pool;

    static{
        //创建一个pool的配置对象,用于设置Jedis连接池的属性
        JedisPoolConfig config = new JedisPoolConfig();
        //实例池最大容纳500个jedis实例
        config.setMaxTotal(500);
        //最小空闲实例
        config.setMinIdle(5);
        //最大连接超时时间
        config.setMaxWaitMillis(2000);
        //初始化实例池对象
        pool = new JedisPool(config, host, prot, 3000, auth);
    }

    public static Jedis getJedis(){
        //从实例池中返回一个jedis实例
        return pool.getResource();
    }

}
