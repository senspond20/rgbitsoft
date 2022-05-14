package com.rgbitsoft.cache.model.dao;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class RedisDaoImpl implements RedisDao{

    private final RedisTemplate redisTemplate;

    @Override
    public void saveKVToHash(String hash, Object key, Object value) {
        redisTemplate.opsForHash().put(hash, key, value);
    }

    @Override
    public void saveMapToHash(String hash, Map map) {
        redisTemplate.opsForHash().putAll(hash, map);
    }

    @Override
    public Map getMapByHash(String hash) {
        return redisTemplate.opsForHash().entries(hash);
    }

    @Override
    public Object getValueByHashKey(String hash, Object key) {
        return redisTemplate.opsForHash().get(hash, key);
    }
    @Override
    public void deleteByHashKey(String hash, Object key) {
        redisTemplate.opsForHash().delete(hash, key);
    }

}
