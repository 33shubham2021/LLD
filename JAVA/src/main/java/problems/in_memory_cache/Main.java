package problems.in_memory_cache;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Starting Manual Cache Tests ===\n");

        // Initialize a cache with a max capacity of 3
        EvictionPolicy policy = new LRUEvictionPolicy();
        Cache cache = new Cache(3, policy);

        // ---------------------------------------------------------
        // SCENARIO 1: Basic Put and Get
        // ---------------------------------------------------------
        System.out.println("--- Scenario 1: Basic Put & Get ---");
        cache.put("user:1", "Alice", 60); // 60 seconds TTL

        System.out.println("Fetching 'user:1' (Expected: Alice) -> Actual: " + cache.get("user:1"));
        System.out.println("Fetching 'user:99' (Expected: null)  -> Actual: " + cache.get("user:99"));
        System.out.println();


        // ---------------------------------------------------------
        // SCENARIO 2: Time-To-Live (TTL) Expiration
        // ---------------------------------------------------------
        System.out.println("--- Scenario 2: TTL Expiration ---");
        cache.put("session:1", "ActiveToken", 1); // Only 1 second TTL!

        System.out.println("Immediately fetching 'session:1' -> " + cache.get("session:1"));

        System.out.println("Waiting for 1.2 seconds...");
        Thread.sleep(1200); // Pause the program to let the TTL expire

        System.out.println("Fetching 'session:1' after wait (Expected: null) -> Actual: " + cache.get("session:1"));
        System.out.println();


        // ---------------------------------------------------------
        // SCENARIO 3: LRU Eviction (When capacity is full)
        // ---------------------------------------------------------
        System.out.println("--- Scenario 3: LRU Eviction ---");
        cache.clear(); // Reset the cache for this test

        System.out.println("Adding 3 items to fill the cache...");
        cache.put("A", "Data A", 60);
        cache.put("B", "Data B", 60);
        cache.put("C", "Data C", 60);

        // Right now, the order from oldest to newest is: A, B, C
        // Let's access "A" so it becomes the MOST recently used.
        System.out.println("Accessing 'A' to make it recently used -> " + cache.get("A"));

        // Now the order is: B (oldest), C, A (newest)
        // Let's add a 4th item. This should force the cache to delete "B".
        System.out.println("Adding item 'D'. The cache is full, so it should evict the oldest item ('B')...");
        cache.put("D", "Data D", 60);

        System.out.println("Fetching 'B' (Expected: null)   -> Actual: " + cache.get("B"));
        System.out.println("Fetching 'A' (Expected: Data A) -> Actual: " + cache.get("A"));
        System.out.println("Fetching 'C' (Expected: Data C) -> Actual: " + cache.get("C"));
        System.out.println("Fetching 'D' (Expected: Data D) -> Actual: " + cache.get("D"));

        System.out.println("\n=== Tests Complete ===");
    }
}