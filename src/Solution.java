import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    nums[i][j] = (j == 0 ? 0 : nums[i][j - 1]) + 1;
                }
            }
        }

        int ans = 0;
        for (int col = 0; col < n; col++) {
            int[] up = new int[m];
            int[] down = new int[m];
            Arrays.fill(down, m);
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            for (int row = 0; row < m; row++) {
                while (!stack.isEmpty() && nums[stack.peek()][col] >= nums[row][col]) {
                    down[stack.peek()] = row;
                    stack.pop();
                }
                up[row] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(row);
            }

            for (int row = 0; row < m; row++) {
                ans = Math.max(ans, nums[row][col] * (down[row] - up[row] - 1));
            }

        }
        return ans;
    }
}