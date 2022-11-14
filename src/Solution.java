class Solution {

    public int totalNQueens(int n) {
        return dfs(n, 0, 0, 0, 0);
    }

    private int dfs(int n, int row, int colFlag, int slashFlag, int backSlashFlag) {
        if (row == n) {
            return 1;
        }
        int usablePosition = (1 << n) - 1 & ~(colFlag | slashFlag | backSlashFlag);
        int ans = 0;
        while (usablePosition != 0) {
            int position = usablePosition & -usablePosition;
            ans += dfs(n, row + 1, colFlag | position, (slashFlag | position) >> 1, (backSlashFlag | position) << 1);
            usablePosition &= usablePosition - 1;
        }

        return ans;
    }


}