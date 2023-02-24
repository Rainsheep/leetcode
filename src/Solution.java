
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

    public ListNode sortList(ListNode head) {
        return sort(head);
    }

    private ListNode sort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode second = sort(slow.next);
        slow.next = null;
        ListNode first = sort(head);
        return merge(first, second);
    }

    private ListNode merge(ListNode first, ListNode second) {
        ListNode head = new ListNode();
        ListNode p = head;
        while (first != null && second != null) {
            if (first.val < second.val) {
                p.next = first;
                p = p.next;
                first = first.next;
            } else {
                p.next = second;
                p = p.next;
                second = second.next;
            }
        }

        if (first == null) {
            p.next = second;
        } else {
            p.next = first;
        }
        return head.next;
    }
}