class Solution {

    int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    boolean ans = false;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] flag;
        int len = word.length();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                flag = new boolean[m][n];
                dfs(board, flag, word, i, j, 0);
                if (ans) {
                    return true;
                }
            }
        }
        return false;
    }

    private void dfs(char[][] board, boolean[][] flag, String word, int x, int y, int index) {
        if (ans) {
            return;
        }

        if (index == word.length()) {
            ans = true;
            return;
        }

        if (!check(board, flag, word, x, y, index)) {
            return;
        }

        flag[x][y] = true;
        for (int i = 0; i < 4; i++) {
            dfs(board, flag, word, x + dir[i][0], y + dir[i][1], index + 1);
        }
        flag[x][y] = false;
    }

    private boolean check(char[][] board, boolean[][] flag, String word, int x, int y, int index) {
        int m = board.length;
        int n = board[0].length;

        if (x < 0 || x >= m || y < 0 || y >= n || flag[x][y]) {
            return false;
        }

        return board[x][y] == word.charAt(index);
    }

}