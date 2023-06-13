import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix[0].length;
        int m = matrix.length;
        int[][] num = new int[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                num[j][i] = matrix[j][i] == '1' ? ((j > 0 ? num[j - 1][i] : 0) + 1) : 0;
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            int[] left = new int[n];
            int[] right = new int[n];
            Arrays.fill(right, n - 1);
            LinkedList<Integer> queue = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                while (!queue.isEmpty() && num[i][queue.getLast()] >= num[i][j]) {
                    Integer index = queue.removeLast();
                    right[index] = j - 1;
                }

                left[j] = queue.isEmpty() ? 0 : (queue.getLast() + 1);
                queue.addLast(j);
            }
//            System.out.println(Arrays.toString(right));

            for (int j = 0; j < n; j++) {
                int width = right[j] - left[j] + 1;
                int l = Math.min(width, num[i][j]);
                ans = Math.max(ans, l * l);
            }
        }

        return ans;

    }
}