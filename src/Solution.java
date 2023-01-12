import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, true, new ArrayDeque<>());
        return ans;
    }

    private void dfs(int[] nums, int index, boolean last, ArrayDeque<Integer> list) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (!last && nums[index] == nums[index - 1]) {
            dfs(nums, index + 1, false, list);
            return;
        }

        dfs(nums, index + 1, false, list);
        list.addLast(nums[index]);
        dfs(nums, index + 1, true, list);
        list.removeLast();
    }

}