import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Solution {

    public boolean isValidSudoku(char[][] board) {
        ArrayList<Set<Integer>> rows = new ArrayList<>();
        ArrayList<Set<Integer>> cols = new ArrayList<>();
        ArrayList<Set<Integer>> groups = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            groups.add(new HashSet<>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] >= '1' && board[i][j] <= '9') {
                    int k = board[i][j] - '0';
                    if (rows.get(i).contains(k)) {
                        return false;
                    }
                    rows.get(i).add(k);
                    if (cols.get(j).contains(k)) {
                        return false;
                    }
                    cols.get(j).add(k);
                    if (groups.get(findGroupIndex(i, j)).contains(k)) {
                        return false;
                    }
                    groups.get(findGroupIndex(i, j)).add(k);
                }
            }
        }
        return true;
    }

    public int findGroupIndex(int x, int y) {
        return x / 3 * 3 + y / 3;
    }
}