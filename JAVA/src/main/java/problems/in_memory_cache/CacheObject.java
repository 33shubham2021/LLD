package problems.in_memory_cache;

public class CacheObject {
    private Object value;
    private long expiryTimestamp;

    public CacheObject(Object value, int ttlSeconds) {
        this.value = value;
        // Convert seconds to milliseconds and add to current time to get the exact death time
        this.expiryTimestamp = System.currentTimeMillis() + (ttlSeconds * 1000L);
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > this.expiryTimestamp;
    }

    public Object getValue() {
        return value;
    }
}