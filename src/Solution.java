import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    ArrayList<List<Integer>> ans = new ArrayList<>();
    ArrayDeque<Integer> list = new ArrayDeque<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(0, true, nums);
        return ans;
    }

    private void dfs(int index, boolean pre, int[] nums) {
        if (nums.length == index) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (!pre && nums[index] == nums[index - 1]) {
            dfs(index + 1, false, nums);
            return;
        }

        dfs(index + 1, false, nums);

        list.add(nums[index]);
        dfs(index + 1, true, nums);
        list.removeLast();
    }
}