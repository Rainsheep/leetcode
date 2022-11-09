import java.util.ArrayList;
import java.util.List;

class Solution {

    int n;
    boolean[] rowFlag;
    boolean[] colFlag;
    boolean[] slashFlag;
    boolean[] backslashFlag;
    boolean[][] map;
    int num;
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        rowFlag = new boolean[n];
        colFlag = new boolean[n];
        slashFlag = new boolean[2 * n];
        backslashFlag = new boolean[2 * n];
        map = new boolean[n][n];

        dfs(0, 0);
        return ans;
    }

    public void dfs(int x, int y) {
        if (x == n) {
            if (num == n) {
                ans.add(genAnsList());
            }
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

    private List<String> genAnsList() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j] ? 'Q' : '.');
            }
            list.add(sb.toString());
        }
        return list;
    }

    private void remove(int x, int y) {
        rowFlag[x] = false;
        colFlag[y] = false;
        slashFlag[x + y] = false;
        backslashFlag[x - y + n] = false;
        num--;
        map[x][y] = false;
    }

    private void put(int x, int y) {
        rowFlag[x] = true;
        colFlag[y] = true;
        slashFlag[x + y] = true;
        backslashFlag[x - y + n] = true;
        num++;
        map[x][y] = true;
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