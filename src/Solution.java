import java.util.ArrayList;
import java.util.List;

class Solution {

    int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int k = 0;
    boolean[][] flag;
    int m, n;

    public List<Integer> spiralOrder(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        flag = new boolean[m][n];
        ArrayList<Integer> ans = new ArrayList<>();

        int x = 0, y = 0;
        flag[x][y] = true;
        ans.add(matrix[x][y]);
        while (ans.size() != m * n) {
            int[] nextIndex = nextIndex(x, y);
            x = nextIndex[0];
            y = nextIndex[1];
            ans.add(matrix[x][y]);
            flag[x][y] = true;
        }

        return ans;

    }

    private int[] nextIndex(int x, int y) {
        int newX = x + dir[k][0];
        int newY = y + dir[k][1];
        if (!check(newX, newY)) {
            k = (k + 1) % 4;
            newX = x + dir[k][0];
            newY = y + dir[k][1];
        }
        return new int[]{newX, newY};
    }

    private boolean check(int x, int y) {
        return x < m && y < n && x >= 0 && y >= 0 && !flag[x][y];
    }
}