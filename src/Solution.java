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
        ListNode p = head;
        int t = k;
        while (t-- > 0) {
            if (p == null) {
                return head;
            }
            p = p.next;
        }

        ListNode newHead = reverse(head, p);
        head.next = reverseKGroup(p, k);
        return newHead;

    }

    public ListNode reverse(ListNode head, ListNode end) {
        ListNode pre = null;
        ListNode curr = head;
        ListNode next;
        while (curr != end) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}