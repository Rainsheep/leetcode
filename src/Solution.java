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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int len = length(head);
        k = k % len;
        if (k == 0) {
            return head;
        }
        ListNode p = head;

        while (k-- > 0) {
            p = p.next;
        }
        ListNode q = head;

        while (p.next != null) {
            q = q.next;
            p = p.next;
        }
        ListNode ret = q.next;
        q.next = null;
        p.next = head;
        return ret;
    }

    private int length(ListNode q) {
        ListNode p = q;
        int ret = 0;
        while (p != null) {
            ret++;
            p = p.next;
        }
        return ret;
    }
}