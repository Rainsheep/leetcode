class Solution {

    public int numDecodings(String s) {
        int sLen = s.length();
        if (sLen == 0 || s.startsWith("0")) {
            return 0;
        }
        int[] dp = new int[sLen + 1];
        dp[0] = 1;
        for (int i = 1; i <= sLen; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            int t = i >= 2 ? (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') : 0;
            if (t > 9 && t < 27) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[sLen];
    }
}