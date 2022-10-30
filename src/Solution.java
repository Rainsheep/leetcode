class Solution {

    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int left = 1;
        int right = height.length - 2;
        while (left <= right) {
            if (leftMax <= rightMax) {
                leftMax = Math.max(leftMax, height[left]);
                ans += leftMax - height[left++];
            } else {
                rightMax = Math.max(rightMax, height[right]);
                ans += rightMax - height[right--];
            }
        }
        return ans;

    }
}