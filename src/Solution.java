class Solution {

    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];

        dp[0][0] = true;
        for (int i = 0; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] =
                            dp[i][j - 2] || (i >= 1 && dp[i - 1][j] && isMatchChar(s.charAt(i - 1), p.charAt(j - 2)));
                } else {
                    dp[i][j] = i != 0 && (dp[i - 1][j - 1] && isMatchChar(s.charAt(i - 1), p.charAt(j - 1)));
                }
            }
        }
        return dp[sLen][pLen];
    }

    private boolean isMatchChar(char a, char b) {
        return b == '.' || a == b;
    }

    public static void main(String[] args) {
        new Solution().isMatch("mississippi", "mis*is*p*");
    }
}