import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Solution {

    ArrayList<Set<Integer>> rows = new ArrayList<>();
    ArrayList<Set<Integer>> cols = new ArrayList<>();
    ArrayList<Set<Integer>> groups = new ArrayList<>();
    char[][] board;
    char[][] newBoard = new char[9][9];

    public void solveSudoku(char[][] board) {
        this.board = board;

        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            groups.add(new HashSet<>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                newBoard[i][j] = board[i][j];
                if (board[i][j] != '.') {
                    int k = board[i][j] - '0';
                    addFlag(i, j, k);
                }
            }
        }
        dfs(0, 0);
    }

    public int findGroupIndex(int x, int y) {
        return x / 3 * 3 + y / 3;
    }

    private boolean dfs(int i, int j) {
        int[] nextIndex = nextIndex(i, j);
        if (i == 9) {
            return true;
        }
        if (newBoard[i][j] != '.') {
            return dfs(nextIndex[0], nextIndex[1]);
        }

        for (int k = 1; k <= 9; k++) {
            if (check(i, j, k)) {
                addFlag(i, j, k);
                board[i][j] = (char) (k + '0');
                boolean res = dfs(nextIndex[0], nextIndex[1]);
                if (res) {
                    return true;
                }
                delFlag(i, j, k);
            }
        }
        return false;
    }

    private int[] nextIndex(int i, int j) {
        if (j == 8) {
            return new int[]{i + 1, 0};
        }
        return new int[]{i, j + 1};
    }

    private boolean check(int x, int y, int val) {
        if (rows.get(x).contains(val)) {
            return false;
        }

        if (cols.get(y).contains(val)) {
            return false;
        }
        return !groups.get(findGroupIndex(x, y)).contains(val);
    }

    private void addFlag(int i, int j, int k) {
        rows.get(i).add(k);
        cols.get(j).add(k);
        groups.get(findGroupIndex(i, j)).add(k);
    }

    private void delFlag(int i, int j, int k) {
        rows.get(i).remove(k);
        cols.get(j).remove(k);
        groups.get(findGroupIndex(i, j)).remove(k);
    }
}
