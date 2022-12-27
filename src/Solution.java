class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = getCount(i, j, m, n, obstacleGrid, dp);
            }
        }
        return dp[m - 1][n - 1];
    }

    private int getCount(int x, int y, int m, int n, int[][] obstacleGrid, int[][] dp) {
        if (x < 0 || x >= m || y < 0 || y >= n || obstacleGrid[x][y] == 1) {
            return 0;
        }
        if (x == 0 && y == 0) {
            return 1;
        }
        if (x == 0) {
            return dp[x][y - 1];
        }
        if (y == 0) {
            return dp[x - 1][y];
        }
        return dp[x - 1][y] + dp[x][y - 1];
    }
}