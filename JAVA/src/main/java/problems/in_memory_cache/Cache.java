package problems.in_memory_cache;

import java.util.concurrent.ConcurrentHashMap;

public class Cache {
    private ConcurrentHashMap<String, CacheObject> map;
    private int capacity;
    private EvictionPolicy evictionPolicy;

    public Cache(int capacity, EvictionPolicy evictionPolicy) {
        this.capacity = capacity;
        this.evictionPolicy = evictionPolicy;
        this.map = new ConcurrentHashMap<>();
    }

    public void put(String key, Object value, int ttlSeconds) {
        // 1. Check if we are full AND this is a brand new key
        if (map.size() >= capacity && !map.containsKey(key)) {
            String keyToEvict = evictionPolicy.evict();
            if (keyToEvict != null) {
                this.delete(keyToEvict);
            }
        }

        // 2. Wrap the value and put it in the map
        CacheObject cacheObject = new CacheObject(value, ttlSeconds);
        map.put(key, cacheObject);

        // 3. Notify the policy that this key was just used
        evictionPolicy.keyAccessed(key);
    }

    public Object get(String key) {
        CacheObject cacheObject = map.get(key);

        // 1. Cache Miss (It doesn't exist)
        if (cacheObject == null) {
            return null;
        }

        // 2. Cache Expired (TTL ran out)
        if (cacheObject.isExpired()) {
            this.delete(key);
            return null;
        }

        // 3. Cache Hit! Notify the policy and return the data
        evictionPolicy.keyAccessed(key);
        return cacheObject.getValue();
    }

    public void delete(String key) {
        map.remove(key);
    }

    // Optional: A helper method to clear the whole cache
    public void clear() {
        map.clear();
        // If we clear the cache, we should recreate the policy state
        this.evictionPolicy = new LRUEvictionPolicy();
    }
}