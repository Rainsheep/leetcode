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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode p = head;
        while (list1 != null || list2 != null) {
            if (list1 == null || list2 != null && list2.val <= list1.val) {
                p.next = list2;
                p = p.next;
                list2 = list2.next;
                p.next = null;
                continue;
            }

            p.next = list1;
            p = p.next;
            list1 = list1.next;
            p.next = null;
        }
        return head.next;
    }
}