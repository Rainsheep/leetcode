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
        ListNode kthElem = findKthElem(head, k);
        if (kthElem == null) {
            return head;
        }

        ListNode next = kthElem.next;
        reverse(head, kthElem);
        head.next = reverseKGroup(next, k);
        return kthElem;
    }

    private ListNode findKthElem(ListNode head, int k) {
        while (k-- > 1) {
            if (head == null) {
                break;
            }
            head = head.next;
        }
        return head;
    }

    private ListNode reverse(ListNode head, ListNode end) {
        if (head == null || head == end) {
            return head;
        }
        ListNode newEnd = end.next;

        ListNode pre = null;
        ListNode now = head;
        ListNode next = head.next;
        while (now != newEnd) {
            now.next = pre;
            pre = now;
            now = next;
            if (now != null) {
                next = now.next;
            }
        }
        return pre;
    }
}