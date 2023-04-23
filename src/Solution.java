class Solution {

    boolean[] rowFlag;
    boolean[] colFlag;
    boolean[] c1;
    boolean[] c2;
    int ans = 0;
    int n;

    public int totalNQueens(int n) {
        rowFlag = new boolean[n];
        colFlag = new boolean[n];
        c1 = new boolean[2 * n];
        c2 = new boolean[2 * n];
        this.n = n;
        dfs(0);

        return ans;
    }

    private void dfs(int now) {
        if (now == n) {
            ans++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (check(now, i)) {
                flag(now, i);
                dfs(now + 1);
                cleanFlag(now, i);
            }
        }
    }

    private void flag(int row, int col) {
        rowFlag[row] = true;
        colFlag[col] = true;
        c1[row + col] = true;
        c2[col - row + n] = true;
    }

    private void cleanFlag(int row, int col) {
        rowFlag[row] = false;
        colFlag[col] = false;
        c1[row + col] = false;
        c2[col - row + n] = false;
    }

    private boolean check(int row, int col) {
        return !rowFlag[row] && !colFlag[col] && !c1[row + col] && !c2[col - row + n];
    }
}