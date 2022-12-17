import java.util.Arrays;

class Solution {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (k > j) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }

                int t = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - t) < Math.abs(target - ans)) {
                    ans = t;
                }
                if (t >= target) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return ans;

    }
}