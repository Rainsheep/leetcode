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

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode p = head;
        ListNode next;
        while (p != null) {
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }
}