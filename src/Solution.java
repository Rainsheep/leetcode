class Solution {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = area(height, left, right);
        while (left < right) {
            ans = Math.max(ans, area(height, left, right));
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }

        }

        return ans;
    }

    private int area(int[] height, int i, int j) {
        return (j - i) * Math.min(height[i], height[j]);
    }
}