import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayDeque<>(), false);
        return ans;
    }

    private void dfs(int[] nums, int index, ArrayDeque<Integer> list, boolean last) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (index > 0 && nums[index] == nums[index - 1] && !last) {
            dfs(nums, index + 1, list, false);
            return;
        }

        dfs(nums, index + 1, list, false);
        list.add(nums[index]);
        dfs(nums, index + 1, list, true);
        list.removeLast();
    }
}