
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
        int n = k;
        ListNode end = head;
        while (n-- > 0) {
            if (end == null) {
                return head;
            }
            end = end.next;
        }

        ListNode newHead = reverse(head, end);
        head.next = reverseKGroup(end, k);
        return newHead;
    }

    private ListNode reverse(ListNode head, ListNode end) {
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