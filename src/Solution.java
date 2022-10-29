class Solution {

    public boolean isMatch(String s, String p) {
        int m = p.length();
        int n = s.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            if (p.charAt(i - 1) != '*') {
                break;
            }
            dp[i][0] = true;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && isMatch(p.charAt(i - 1), s.charAt(j - 1));
                }
            }
        }
        return dp[m][n];
    }

    private boolean isMatch(char c1, char c2) {
        if (c1 == '?') {
            return true;
        }
        return c1 == c2;
    }
}