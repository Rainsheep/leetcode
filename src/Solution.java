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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode p = newHead;
        ListNode beginPre = null;
        ListNode begin = null;
        ListNode pre = null;
        ListNode next;
        for (int i = 0; i <= right; i++) {
            if (i == left - 1) {
                beginPre = p;
            }
            if (i == left) {
                begin = p;
            }
            if (i > left) {
                next = p.next;
                p.next = pre;
                if (i == right) {
                    beginPre.next = p;
                    begin.next = next;
                    break;
                }

                pre = p;
                p = next;

                continue;
            }
            pre = p;
            p = p.next;

        }

        return newHead.next;
    }
}