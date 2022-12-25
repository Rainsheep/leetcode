class Solution {

    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int ans = 0;
        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax <= rightMax) {
                ans += leftMax - height[left++];
            } else {
                ans += rightMax - height[right--];
            }

        }
        return ans;
    }
}