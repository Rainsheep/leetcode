class Solution {

    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";
        for (int i = 0; i < n; i++) {
            String ret = fun(s, i);
            if (ret.length() > res.length()) {
                res = ret;
            }
        }
        return res;

    }

    public String fun(String s, int index) {
        int len = 1;
        int left = index - 1;
        int right = index + 1;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            len++;
        }
        String ret1 = s.substring(index - len + 1, index + len);

        len = 0;
        left = index;
        right = index + 1;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            len++;
        }
        String ret2 = s.substring(index - len + 1, index + len + 1);
        return ret1.length() >= ret2.length() ? ret1 : ret2;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("cbbd"));
    }
}