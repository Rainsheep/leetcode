import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        ListNode head = new ListNode();
        ListNode p = head;
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            p.next = poll;
            p = p.next;
            poll = poll.next;
            if (poll != null) {
                queue.add(poll);
            }
        }
        return head.next;
    }
}