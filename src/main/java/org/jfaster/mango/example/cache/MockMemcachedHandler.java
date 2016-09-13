package org.jfaster.mango.example.cache;

import org.jfaster.mango.operator.cache.SimpleCacheHandler;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MockMemcachedHandler extends SimpleCacheHandler {

    private ConcurrentHashMap<String, Object> memcached = new ConcurrentHashMap<String, Object>();

    @Override
    public Object get(String key, Type type) {
        return memcached.get(key);
    }

    @Override
    public Map<String, Object> getBulk(Set<String> keys, Type type) {
        Map<String, Object> map = new HashMap<String, Object>();
        for (String key : keys) {
            map.put(key, memcached.get(key));
        }
        return map;
    }

    @Override
    public void set(String key, Object value, int expires) {
        memcached.put(key, value);
    }

    @Override
    public void delete(String key) {
        memcached.remove(key);
    }

}
