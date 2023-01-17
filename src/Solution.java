import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(right, len);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                Integer pop = stack.pop();
                right[pop] = i;
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            int area = (right[i] - left[i] - 1) * heights[i];
            ans = Math.max(ans, area);
        }
        return ans;
    }
}