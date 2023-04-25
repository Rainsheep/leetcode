import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {

    // [2,1,5,6,2,3]
    public int largestRectangleArea(int[] heights) {
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

    public static void main(String[] args) {
        new Solution().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
    }
}