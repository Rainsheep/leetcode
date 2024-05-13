class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode next = head.next;
        ListNode lastNode = head.next.next;
        head.next.next = head;
        head.next = swapPairs(lastNode);

        return next;

    }
}