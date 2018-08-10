package com.xsx.ce.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@EnableAutoConfiguration
public class JedisPoolBootConfig {
    Logger logger = LoggerFactory.getLogger(JedisPoolBootConfig.class);

    @Bean
    public JedisPool jedisPoolFactory() {
        logger.info("JedisPool注入："+":");
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);

        //有密码
        //JedisPool pool = new JedisPool(jedisPoolConfig,host,port,timeout,password);
        //无密码
        JedisPool pool = new JedisPool(jedisPoolConfig,host,port,timeout);
        return pool;
    }

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.ce.timeout}")
    private int timeout;

    @Value("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.pool.ce.max-wait}")
    private long maxWaitMillis;

    @Value("${spring.redis.password}")
    private String password;
}
