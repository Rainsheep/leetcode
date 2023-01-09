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

    public ListNode deleteDuplicates(ListNode head) {
        head = findFirst(head);
        if (head == null) {
            return null;
        }

        int repeatValue = 200;
        ListNode p = head;
        while (p.next != null) {
            if (p.next.val == repeatValue || p.next.next != null && p.next.val == p.next.next.val) {
                repeatValue = p.next.val;
                p.next = p.next.next;
                continue;
            }
            p = p.next;
        }
        return head;
    }

    private ListNode findFirst(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            int preVal = pre == null ? 200 : pre.val;
            int headNextVal = head.next == null ? 200 : head.next.val;
            if (head.val != preVal & head.val != headNextVal) {
                break;
            }
            pre = head;
            head = head.next;
        }
        return head;
    }
}