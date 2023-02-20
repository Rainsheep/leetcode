import java.util.HashMap;

public class LRUCache {

    private static class Node {

        int key;
        int value;
        Node pre;
        Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, Node> cache = new HashMap<>();
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            moveToLast(node);
            return node.value;
        }
        return -1;
    }

    private void moveToLast(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;

        addToTail(node);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            moveToLast(node);
            return;
        }

        Node node = new Node(key, value);
        addToTail(node);
        cache.put(key, node);

        if (cache.size() > capacity) {
            int removeKey = removeHead();
            cache.remove(removeKey);
        }
    }

    private void addToTail(Node node) {
        tail.pre.next = node;

        node.pre = tail.pre;
        node.next = tail;

        tail.pre = node;
    }

    private int removeHead() {
        Node node = head.next;
        head.next = node.next;
        node.next.pre = head;
        return node.key;
    }


}