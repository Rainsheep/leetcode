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
        ListNode head = new ListNode();
        ListNode p = head;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(value -> value.val));
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }

        while (!queue.isEmpty()) {
            ListNode tList = queue.remove();
            p.next = tList;
            p = p.next;
            if (tList.next != null) {
                queue.add(tList.next);
            }
        }
        return head.next;
    }
}