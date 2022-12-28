class Solution {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int min;
                if (i == 0 && j == 0) {
                    min = 0;
                } else if (i == 0) {
                    min = dp[i][j - 1];
                } else if (j == 0) {
                    min = dp[i - 1][j];
                } else {
                    min = Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
                dp[i][j] = min + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];

    }
}