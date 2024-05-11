import java.util.LinkedList;

class Solution {
    public int longestValidParentheses(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }

        return res;

    }
}