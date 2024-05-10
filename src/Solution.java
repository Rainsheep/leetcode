class Solution {
    public int longestValidParentheses(String s) {
        int res = 0;
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else {
                right++;
            }

            if (left >= right) {
                res = Math.max(res, right * 2);
            } else {
                left = 0;
                right = 0;
            }
        }
        return res;

    }
}