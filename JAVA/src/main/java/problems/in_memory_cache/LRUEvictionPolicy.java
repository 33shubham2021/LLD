package problems.in_memory_cache;

import java.util.LinkedHashSet;

public class LRUEvictionPolicy implements EvictionPolicy {

    // LinkedHashSet maintains insertion order.
    // The first item is the oldest (LRU), the last item is the newest.
    private LinkedHashSet<String> lruSet;

    public LRUEvictionPolicy() {
        this.lruSet = new LinkedHashSet<>();
    }

    @Override
    public synchronized void keyAccessed(String key) {
        // Remove it if it exists, then add it back to push it to the "newest" end of the line
        lruSet.remove(key);
        lruSet.add(key);
    }

    @Override
    public synchronized String evict() {
        if (lruSet.isEmpty()) {
            return null;
        }
        // Grab the very first item (the oldest/least recently used)
        String leastRecentlyUsedKey = lruSet.iterator().next();
        lruSet.remove(leastRecentlyUsedKey);

        return leastRecentlyUsedKey;
    }
}