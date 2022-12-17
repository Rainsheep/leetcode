class Solution {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ret = 0;

        while (left < right) {
            ret = Math.max(ret, (right - left) * Math.min(height[left], height[right]));
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return ret;

    }
}