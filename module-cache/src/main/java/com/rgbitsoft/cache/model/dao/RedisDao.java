package com.rgbitsoft.cache.model.dao;

import java.util.List;
import java.util.Map;

public interface RedisDao {

    void saveKVToHash(String hash, Object key, Object value);

    void saveMapToHash(String hash, Map map);

    Map getMapByHash(String hash);

    Object getValueByHashKey(String hash, Object key);

    void deleteByHashKey(String hash, Object key);
}
