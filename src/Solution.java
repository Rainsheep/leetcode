import java.util.HashMap;
import java.util.Map;

class LRUCache {

    static class ListNode {
        int key;
        int val;
        ListNode pre;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer, ListNode> map;

    int capacity;

    ListNode head;
    ListNode tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            moveToHead(map.get(key));
            return map.get(key).val;
        }
        return -1;
    }

    private void moveToHead(ListNode listNode) {
        listNode.pre.next = listNode.next;
        listNode.next.pre = listNode.pre;
        addToHead(listNode);
    }

    private void addToHead(int key, int val) {
        addToHead(new ListNode(key, val));
    }

    private void addToHead(ListNode listNode) {
        map.put(listNode.key, listNode);
        listNode.next = head.next;
        listNode.pre = head;
        head.next.pre = listNode;
        head.next = listNode;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).val = value;
            moveToHead(map.get(key));
        } else if (map.size() < capacity) {
            addToHead(key, value);
        } else {
            addToHead(key, value);
            removeTail();

        }

    }

    private void removeTail() {
        ListNode realTail = tail.pre;
        removeNode(realTail);
        map.remove(realTail.key);
    }

    private void removeNode(ListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

}

