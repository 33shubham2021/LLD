package problems.in_memory_cache;

public interface EvictionPolicy {
    // Called by the Cache whenever an item is put or retrieved
    void keyAccessed(String key);

    // Called by the Cache when it runs out of space; returns the key to delete
    String evict();
}