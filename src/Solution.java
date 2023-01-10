import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution {

    HashSet<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayDeque<>());
        return new ArrayList<>(set);
    }

    private void dfs(int[] nums, int index, ArrayDeque<Integer> list) {
        if (index == nums.length) {
            set.add(new ArrayList<>(list));
            return;
        }

        dfs(nums, index + 1, list);
        list.add(nums[index]);
        dfs(nums, index + 1, list);
        list.removeLast();
    }
}