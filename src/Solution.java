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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode now = head;

        ListNode pre = new ListNode();
        pre.next = now;

        ListNode p = head;

        int k = n + 1;
        while (k-- > 1) {
            p = p.next;
        }

        while (p != null) {
            p = p.next;
            now = now.next;
            pre = pre.next;
        }

        if (pre.next == head) {
            return head.next;
        }
        pre.next = pre.next.next;
        return head;
    }
}