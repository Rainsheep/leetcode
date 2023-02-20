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
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode newHead = new ListNode();
        ListNode p = newHead;
        while (a != null || b != null) {
            if (a == null) {
                p.next = b;
                break;
            }

            if (b == null) {
                p.next = a;
                break;
            }

            if (a.val <= b.val) {
                p.next = a;
                a = a.next;
            } else {
                p.next = b;
                b = b.next;

            }
            p = p.next;
        }

        return newHead.next;

    }
}