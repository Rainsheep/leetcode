class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix[0].length;
        int m = matrix.length;
        int[][] dp = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = (i == 0 || j == 0) ? 1 : (Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1);
                    ans = Math.max(dp[i][j], ans);
                }
            }
        }
        return ans * ans;

    }
}