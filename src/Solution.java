import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] left = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }

        int ans = 0;
        int[] up = new int[m];
        int[] down = new int[m];
        for (int col = 0; col < n; col++) {
            Arrays.fill(down, m);
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            for (int row = 0; row < m; row++) {
                while (!stack.isEmpty() && left[stack.peek()][col] >= left[row][col]) {
                    Integer pop = stack.pop();
                    down[pop] = row;
                }
                up[row] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(row);
            }

            for (int i = 0; i < m; i++) {
                int area = left[i][col] * (down[i] - up[i] - 1);
                ans = Math.max(ans, area);
            }
        }

        return ans;
    }
}