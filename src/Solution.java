import java.util.LinkedHashMap;
import java.util.Map.Entry;

class LRUCache extends LinkedHashMap<Integer, Integer> {


    int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return this.getOrDefault(key, -1);
    }


    @Override
    protected boolean removeEldestEntry(Entry<Integer, Integer> eldest) {
        return this.size() > capacity;
    }
}