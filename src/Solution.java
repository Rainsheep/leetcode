
class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {

    public boolean hasCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null) {
            p2 = p2.next;
            if (p2 == null) {
                return false;
            }
            p2 = p2.next;
            p1 = p1.next;

            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }
}
