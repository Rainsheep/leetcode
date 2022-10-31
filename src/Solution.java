import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        dfs(new LinkedList<>(), nums, new boolean[nums.length]);
        return ans;
    }

    private void dfs(LinkedList<Integer> list, int[] nums, boolean[] flag) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < flag.length; i++) {
            if (!flag[i] && !set.contains(nums[i])) {
                set.add(nums[i]);
                list.add(nums[i]);
                flag[i] = true;
                dfs(list, nums, flag);
                flag[i] = false;
                list.removeLast();
            }
        }

    }
}