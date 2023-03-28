
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
        int n = 2;
        ListNode ans = new ListNode();
        ListNode pre = ans;
        ans.next = head;
        while (pre != null && pre.next != null) {
            ListNode[] listNodes = convertList(pre.next, n);
            pre.next = listNodes[0];
            pre = listNodes[1];
        }

        return ans.next;
    }

    private ListNode findTail(ListNode head, int n) {
        n = n - 1;
        while (n-- > 0) {
            if (head == null) {
                break;
            }
            head = head.next;
        }
        return head;
    }

    private ListNode[] convertList(ListNode head, int k) {
        ListNode tail = findTail(head, k);

        if (tail == null) {
            return new ListNode[]{head, null};
        }

        ListNode p = head;
        ListNode pre = null;
        ListNode next = p.next;

        while (k-- > 0) {
            p.next = pre;
            pre = p;
            p = next;
            if (p != null) {
                next = p.next;
            }

        }
        head.next = p;

        return new ListNode[]{pre, head};
    }
}