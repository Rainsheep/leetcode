class Solution {

    boolean[] col;
    boolean[] slash;
    boolean[] slash2;
    int ans = 0;
    int n;

    public int totalNQueens(int n) {
        this.n = n;
        col = new boolean[n];
        slash = new boolean[2 * n];
        slash2 = new boolean[2 * n];
        dfs(0);
        return ans;
    }

    private void dfs(int k) {
        if (k == n) {
            ans++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isVail(k, i)) {
                lock(k, i);
                dfs(k + 1);
                unLock(k, i);
            }
        }
    }

    private boolean isVail(int x, int y) {
        if (col[y]) {
            return false;
        }

        if (slash[y - x + n]) {
            return false;
        }

        if (slash2[x + y]) {
            return false;
        }
        return true;
    }

    private void lock(int x, int y) {
        col[y] = true;
        slash[y - x + n] = true;
        slash2[x + y] = true;
    }

    private void unLock(int x, int y) {
        col[y] = false;
        slash[y - x + n] = false;
        slash2[x + y] = false;
    }

}