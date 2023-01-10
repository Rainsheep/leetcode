import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class Solution {

    HashSet<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        dfs(nums, 0, new ArrayDeque<>());
        return new ArrayList<>(set);
    }

    private void dfs(int[] nums, int index, ArrayDeque<Integer> list) {
        if (index == nums.length) {
            ArrayList<Integer> t = new ArrayList<>(list);
            Collections.sort(t);
            set.add(t);
            return;
        }

        list.add(nums[index]);
        dfs(nums, index + 1, list);
        list.removeLast();
        dfs(nums, index + 1, list);
    }
}