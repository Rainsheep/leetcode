import java.util.LinkedList;

class Solution {
    public int longestValidParentheses(String s) {
        LinkedList<Integer> list = new LinkedList<>();
        list.push(-1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                list.push(i);
            } else {
                list.pop();
                if (list.isEmpty()) {
                    list.push(i);
                } else {
                    res = Math.max(res, i - list.peek());
                }

            }
        }
        return res;
    }
}
