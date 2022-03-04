package com.example.zh.redistest.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Author: zhaih
 * @Date: 2022/3/4
 * @Time: 14:37
 * @Description: redis配置类
 */
@Configuration
@EnableCaching
public class RedisConfig {
    /**
     * 配置redisTemplate
     * @param factory 容器注入连接工厂
     * @return redisTemplate
     */
    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory factory){
//        创建对象
        RedisTemplate<String,Object> template=new RedisTemplate<>();
//        连接工厂
        template.setConnectionFactory(factory);
        //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值（默认使用JDK的序列化方式）
        Jackson2JsonRedisSerializer jacksonSerial=new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper om =new ObjectMapper();
        // 指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
// 指定序列化输入的类型，类必须是非final修饰的，final修饰的类，比如String,Integer等会跑出异常
        om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL);
        jacksonSerial.setObjectMapper(om);

        // 值采用json序列化
        template.setValueSerializer(jacksonSerial);

//        使用 StringRedisSerializer来序列化和反序列化redis的key
        template.setHashKeySerializer(new StringRedisSerializer());
// 设置hash key 和value序列化模式
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(jacksonSerial);
        template.afterPropertiesSet();

        return template;
    }

    /**
     * 对hash类型的数据操作
     *
     * @param template
     * @return
     */
    @Bean
    public HashOperations<String,String,Object> hashOperations(RedisTemplate<String,Object> template){
        return template.opsForHash();
    }

    /**
     * 对redis字符串类型数据操作
     *
     * @param template
     * @return
     */
    @Bean
    public ValueOperations<String,Object> valueOperations(RedisTemplate<String,Object> template){
        return template.opsForValue();
    }

    /**
     * 对链表类型的数据操作
     *
     * @param template
     * @return
     */
    @Bean
    public ListOperations<String,Object> listOperations(RedisTemplate<String,Object> template){
        return template.opsForList();
    }

    /**
     * 对无序集合类型的数据操作
     *
     * @param template
     * @return
     */
    @Bean
    public SetOperations<String,Object> setOperations(RedisTemplate<String,Object> template){
        return template.opsForSet();
    }

    /**
     * 对有序集合类型的数据操作
     *
     * @param redisTemplate
     * @return
     */
    @Bean
    public ZSetOperations<String, Object> zSetOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForZSet();
    }
}
