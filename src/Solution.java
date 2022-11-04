import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        ArrayList<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                if (left != i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                int res = nums[i] + nums[left] + nums[right];
                if (res == 0) {
                    ans.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (res > 0) {
                    right--;
                } else {
                    left++;
                }
            }

        }
        return ans;
    }
}