import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {

    ArrayList<List<Integer>> ans = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        dfs(0, new LinkedList<>(), false);

        return ans;
    }

    private void dfs(int i, LinkedList<Integer> list, boolean last) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        // no select
        dfs(i + 1, list, false);
        // select
        if (last || i == 0 || nums[i] != nums[i - 1]) {
            list.add(nums[i]);
            dfs(i + 1, list, true);
            list.removeLast();
        }
    }
}