class Solution {

    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i] = 0;
            if (check(String.valueOf(s.charAt(i)))) {
                dp[i] = i == 0 ? 1 : dp[i - 1];
            }

            if (i >= 1 && check(s.substring(i - 1, i + 1))) {
                dp[i] += i == 1 ? 1 : dp[i - 2];
            }
        }
        return dp[s.length() - 1];
    }

    private boolean check(String s) {
        if (s.startsWith("0")) {
            return false;
        }
        int num = Integer.parseInt(s);
        return num >= 1 && num <= 26;
    }
}