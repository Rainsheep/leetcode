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

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node2 = head.next;
        if (node2 == null) {
            return head;
        }
        head.next = swapPairs(node2.next);
        node2.next = head;
        return node2;
    }
}