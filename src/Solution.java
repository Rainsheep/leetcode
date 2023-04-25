import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {

    public int maximalRectangle(char[][] matrix) {
        int ans = 0;
        int[][] nums = convert(matrix);
        for (int[] num : nums) {
            ans = Math.max(ans, largestRectangleArea(num));
        }
        return ans;
    }

    private int[][] convert(char[][] matrix) {
        int[][] res = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    res[i][j] = i == 0 ? 1 : res[i - 1][j] + 1;
                }
            }
        }

        return res;
    }

    private int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!queue.isEmpty() && heights[i] < heights[queue.peek()]) {
                Integer t = queue.poll();
                right[t] = i;
            }
            left[i] = queue.isEmpty() ? -1 : queue.peek();
            queue.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max((right[i] - left[i] - 1) * heights[i], ans);
        }
        return ans;
    }
}