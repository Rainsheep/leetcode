class Solution {

    public int totalNQueens(int n) {
        return dfs(n, 0, 0, 0, 0);
    }

    private int dfs(int n, int row, int colFlag, int slashFlag, int backSlashFlag) {
        if (row == n) {
            return 1;
        }
        int ans = 0;
        // 1 为可用
        int usablePosition = ((1 << n) - 1) & ~(colFlag | slashFlag | backSlashFlag);
        while (usablePosition != 0) {
            int position = usablePosition & -usablePosition;
            usablePosition = usablePosition & (usablePosition - 1);
            ans += dfs(n, row + 1, colFlag | position, (slashFlag | position) >> 1, (backSlashFlag | position) << 1);
        }
        return ans;
    }


}