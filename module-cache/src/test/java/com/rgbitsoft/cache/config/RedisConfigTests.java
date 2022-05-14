package com.rgbitsoft.cache.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisConfigTests {

    @Autowired
    private RedisTemplate redisTemplate;

    private final String KEY = "senshig";
    private final String VALUE = "loveyou";

    @Test
    public void test(){
        ValueOperations<String, String> vop = redisTemplate.opsForValue();
        vop.set(KEY, VALUE);
        String value = vop.get(KEY);
        System.out.println(String.format("KEY : %s , VALUE : %s", KEY, value));
        assertEquals(value, VALUE);
    }
}
