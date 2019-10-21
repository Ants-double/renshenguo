package com.antsdouble.learnsession.controller;

import com.antsdouble.learnsession.pv.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author lyy
 * @description
 * @date 2019/5/14
 */
@Configuration
public class RedisConfig {

    @Bean("userRedisTemplate")
    public RedisTemplate<String, User> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, User> template = new RedisTemplate<>();
        Jackson2JsonRedisSerializer<User> j = new Jackson2JsonRedisSerializer<User>(User.class);
        template.setValueSerializer(j);
        template.setHashValueSerializer(j);

        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }


}
