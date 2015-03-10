package org.jfaster.mango.example.cache;

import org.jfaster.mango.operator.cache.CacheHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class CacheHandlerImpl implements CacheHandler {

    private ConcurrentHashMap<String, Object> cache = new ConcurrentHashMap<String, Object>();

    @Override
    public Object get(String key) {
        return cache.get(key);
    }

    @Override
    public Map<String, Object> getBulk(Set<String> keys) {
        Map<String, Object> map = new HashMap<String, Object>();
        for (String key : keys) {
            map.put(key, cache.get(key));
        }
        return map;
    }

    @Override
    public void set(String key, Object value, int expires) {
        cache.put(key, value);
    }

    @Override
    public void delete(Set<String> keys) {
        for (String key : keys) {
            delete(key);
        }
    }

    @Override
    public void delete(String key) {
        cache.remove(key);
    }
}
