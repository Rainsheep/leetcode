
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

    public ListNode partition(ListNode head, int x) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode lessNode = newHead;
        ListNode bigNode = null;
        ListNode now = head;
        ListNode pre = newHead;
        while (now != null) {
            if (now.val >= x) {
                if (bigNode == null) {
                    bigNode = now;
                }
                pre = now;
                now = now.next;
            } else {
                if (bigNode == null) {
                    pre = now;
                    now = now.next;
                } else {
                    pre.next = now.next;
                    now.next = lessNode.next;
                    lessNode.next = now;
                    now = pre.next;
                }
                lessNode = lessNode.next;
            }


        }

        return newHead.next;
    }
}