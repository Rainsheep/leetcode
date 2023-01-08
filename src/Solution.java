class Solution {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int left = dp[i][j - 1] + 1;
                int up = dp[i - 1][j] + 1;
                int leftUp = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    leftUp += 1;
                }
                dp[i][j] = Math.min(leftUp, Math.min(left, up));
            }
        }
        return dp[m][n];

    }
}