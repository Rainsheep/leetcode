class Solution {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[0][j] = j;
                } else if (j == 0) {
                    dp[i][0] = i;
                } else {
                    int up = dp[i - 1][j] + 1;
                    int left = dp[i][j - 1] + 1;
                    int leftUp = dp[i - 1][j - 1];
                    if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                        leftUp++;
                    }
                    dp[i][j] = Math.min(up, Math.min(leftUp, left));
                }
            }
        }

        return dp[m][n];
    }
}