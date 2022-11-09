class Solution {

    int n;
    boolean[] rowFlag;
    boolean[] colFlag;
    boolean[] slashFlag;
    boolean[] backslashFlag;
    int num;
    int ans;

    public int totalNQueens(int n) {
        this.n = n;
        rowFlag = new boolean[n];
        colFlag = new boolean[n];
        slashFlag = new boolean[2 * n];
        backslashFlag = new boolean[2 * n];

        dfs(0, 0);
        return ans;
    }

    public void dfs(int x, int y) {
        if (x == n) {
            ans += num == n ? 1 : 0;
            return;
        }

        int[] nextIndex = nextIndex(x, y);
        boolean res = check(x, y);
        if (res) {
            put(x, y);
            dfs(nextIndex[0], nextIndex[1]);
            remove(x, y);
        }

        dfs(nextIndex[0], nextIndex[1]);
    }

    private void remove(int x, int y) {
        rowFlag[x] = false;
        colFlag[y] = false;
        slashFlag[x + y] = false;
        backslashFlag[x - y + n] = false;
        num--;
    }

    private void put(int x, int y) {
        rowFlag[x] = true;
        colFlag[y] = true;
        slashFlag[x + y] = true;
        backslashFlag[x - y + n] = true;
        num++;
    }

    private boolean check(int x, int y) {
        if (rowFlag[x]) {
            return false;
        }
        if (colFlag[y]) {
            return false;
        }
        if (slashFlag[x + y]) {
            return false;
        }
        if (backslashFlag[x - y + n]) {
            return false;
        }
        return true;
    }

    public int[] nextIndex(int x, int y) {
        if (y == n - 1) {
            return new int[]{x + 1, 0};
        }
        return new int[]{x, y + 1};
    }
}