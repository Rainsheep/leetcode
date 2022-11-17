class Solution {

    int[][] ans;
    int n;
    int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int k = 0;

    public int[][] generateMatrix(int n) {
        this.n = n;
        ans = new int[n][n];
        int[] nowIndex = {0, 0};
        for (int i = 0; i < n * n; i++) {
            if (i != 0) {
                nowIndex = nextIndex(nowIndex[0], nowIndex[1]);
            }

            ans[nowIndex[0]][nowIndex[1]] = i + 1;
        }
        return ans;

    }

    private int[] nextIndex(int x, int y) {
        int nextX = x + dir[k][0];
        int nextY = y + dir[k][1];
        if (checkIndex(nextX, nextY)) {
            return new int[]{nextX, nextY};
        }
        k = (k + 1) % 4;
        return new int[]{x + dir[k][0], y + dir[k][1]};
    }

    private boolean checkIndex(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n && ans[x][y] == 0;
    }

}