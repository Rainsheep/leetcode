import java.util.ArrayList;
import java.util.LinkedList;

class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        LinkedList<Integer> stack = new LinkedList<>();
        int[] ans = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            if (stack.isEmpty() || list.get(i) <= list.get(stack.peek())) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && list.get(i) > list.get(stack.peek())) {
                    Integer index = stack.pop();
                    ans[index] = list.get(i);
                }
                stack.push(i);
            }
        }

        return ans;

    }
}