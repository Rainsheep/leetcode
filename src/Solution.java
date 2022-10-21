import java.util.LinkedList;

class Solution {

    public int longestValidParentheses(String s) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);

        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                list.add(0);
            } else {
                if (list.size() > 1) {
                    Integer nowNum = list.removeLast();
                    list.set(list.size() - 1, list.get(list.size() - 1) + nowNum + 2);
                    ans = Math.max(ans, list.get(list.size() - 1));
                } else {
                    list.set(0, 0);
                }
            }
        }

        return ans;
    }
}