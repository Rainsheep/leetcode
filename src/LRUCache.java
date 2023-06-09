import java.util.HashMap;
import java.util.Objects;

class LRUCache {

    static class Node<K, V> {

        K key;
        V value;
        Node<K, V> pre;
        Node<K, V> next;

        public Node(K key, V value, Node<K, V> pre, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
    }

    int capacity;

    HashMap<Integer, Node<Integer, Integer>> map;
    Node<Integer, Integer> head;
    Node<Integer, Integer> tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node<Integer, Integer> node = map.get(key);
        if (node != null) {
            move2Tail(node);
            return node.value;
        }
        return -1;
    }

    public void put(Integer key, Integer value) {
        if (map.containsKey(key)) {
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            move2Tail(node);
        } else {
            Node<Integer, Integer> node = new Node<>(key, value, null, null);
            map.put(key, node);
            add2Tail(node);

            if (map.size() > capacity) {
                map.remove(head.key);
                head = head.next;
            }
        }
    }

    private void move2Tail(Node<Integer, Integer> node) {
        if (Objects.equals(node.key, tail.key)) {
            return;
        }

        if (Objects.equals(node.key, head.key)) {
            head = head.next;
            add2Tail(node);
            return;
        }

        node.pre.next = node.next;
        node.next.pre = node.pre;
        add2Tail(node);

    }

    private void add2Tail(Node<Integer, Integer> node) {
        node.pre = tail;
        if (tail != null) {
            tail.next = node;
        }
        tail = node;
        if (head == null) {
            head = node;
        }
    }

}
