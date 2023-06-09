import java.util.LinkedHashMap;
import java.util.Map.Entry;

class LRUCache extends LinkedHashMap<Integer, Integer> {

    int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return getOrDefault(key, -1);
    }

    @Override
    protected boolean removeEldestEntry(Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj = new LRUCache(capacity); int param_1 =
 * obj.get(key); obj.put(key,value);
 */