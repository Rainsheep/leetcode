import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> ans = new ArrayList<>();
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
                if (t == 0) {
                    ans.add(List.of(nums[i], nums[j], nums[k]));
                    k--;
                    j++;
                } else if (t > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return ans;

    }
}