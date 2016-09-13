package org.jfaster.mango.example.cache;

import com.alibaba.fastjson.JSON;
import org.jfaster.mango.operator.cache.SimpleCacheHandler;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MockRedisHandler extends SimpleCacheHandler {

    private ConcurrentHashMap<String, String> redis = new ConcurrentHashMap<String, String>();

    @Override
    public Object get(String key, Type type) {
        String json = redis.get(key);
        Object value = JSON.parseObject(json, type); // json数据反序列化为java对象
        return value;
    }

    @Override
    public Map<String, Object> getBulk(Set<String> keys, Type type) {
        Map<String, Object> map = new HashMap<String, Object>();
        for (String key : keys) {
            map.put(key, redis.get(key));
        }
        return map;
    }

    @Override
    public void set(String key, Object value, int expires) {
        String json = JSON.toJSONString(value); // java对象序列化为json数据
        redis.put(key, json);
    }

    @Override
    public void delete(String key) {
        redis.remove(key);
    }

}
