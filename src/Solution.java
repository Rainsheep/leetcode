import java.util.HashMap;

class LRUCache {

    static class Node {

        int key;
        int value;
        Node next;
        Node pre;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        moveToTail(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToTail(node);
        } else if (map.size() == capacity) {
            removeHead();
            Node node = new Node(key, value);
            addTail(node);
        } else {
            Node node = new Node(key, value);
            addTail(node);
        }
    }

    private void removeHead() {
        map.remove(head.next.key);
        head.next = head.next.next;
        head.next.pre = head;
    }

    private void addTail(Node node) {
        map.put(node.key, node);
        node.next = tail;
        node.pre = tail.pre;
        tail.pre.next = node;
        tail.pre = node;
    }

    private void moveToTail(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        addTail(node);
    }
}