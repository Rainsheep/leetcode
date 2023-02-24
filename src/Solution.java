class Solution {

    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] flag = new boolean[m][n];
        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !flag[i][j]) {
                    ret++;
                    dfs(grid, flag, m, n, i, j);
                }
            }
        }
        return ret;

    }

    private void dfs(char[][] grid, boolean[][] flag, int m, int n, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || flag[i][j] || grid[i][j] == '0') {
            return;
        }
        flag[i][j] = true;
        for (int[] d : dir) {
            dfs(grid, flag, m, n, i + d[0], j + d[1]);
        }
    }
}