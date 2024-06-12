import java.util.ArrayList;

class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int[] ans = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {

            if (i > 0 && list.get(i) <= list.get(i - 1)) {
                ans[i] = ans[i - 1];
            }

            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) > list.get(i)) {
                    ans[i] = list.get(j);
                    break;
                }
            }
        }


        return ans;

    }
}