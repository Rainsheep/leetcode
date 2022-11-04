
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

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode end = head;
        for (int i = 0; i < k; i++) {
            end = end.next;
            if (i != k - 1 && end == null) {
                return head;
            }
        }
        ListNode newHead = reverse(head, end);
        head.next = reverseKGroup(end, k);
        return newHead;

    }

    public ListNode reverse(ListNode head, ListNode end) {
        ListNode pre = null;
        ListNode next;
        ListNode cur = head;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}