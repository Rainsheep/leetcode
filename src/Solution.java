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

    public boolean isPalindrome(ListNode head) {
        int len = calcLen(head);
        if (len <= 1) {
            return true;
        }
        return fun(head, len);


    }

    private int calcLen(ListNode head) {
        ListNode p = head;
        int res = 0;
        while (p != null) {
            res++;
            p = p.next;
        }
        return res;
    }

    private boolean fun(ListNode head, int len) {
        ListNode p = head;
        int mid = (len + 1) / 2;
        int i = 0;
        ListNode pre = null;
        ListNode next;
        while (true) {
            i++;
            if (i == mid + 1) {
                break;
            }

            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        if (len % 2 != 0) {
            pre = pre.next;
        }

        return isSame(pre, p);

    }

    private boolean isSame(ListNode pre, ListNode p) {
        while (true) {
            if (pre == null && p == null) {
                return true;
            }
            if (pre == null || p == null) {
                return false;
            }
            if (pre.val != p.val) {
                return false;
            }

            pre = pre.next;
            p = p.next;
        }
    }
}