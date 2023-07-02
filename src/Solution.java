class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += oddExd(i, s);
            ans += evenExd(i, s);
        }
        return ans;
    }

    private int oddExd(int index, String s) {
        int res = 1;
        int left = index - 1;
        return test(index, s, res, left);
    }

    private int evenExd(int index, String s) {
        int res = 0;
        return test(index, s, res, index);
    }

    private int test(int index, String s, int res, int left) {
        int right = index + 1;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            res++;
            left--;
            right++;
        }
        return res;
    }
}