import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(new LinkedList<>(), nums, new boolean[nums.length]);
        return ans;
    }

    private void dfs(LinkedList<Integer> list, int[] nums, boolean[] flag) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < flag.length; i++) {
            if (!flag[i]) {
                list.add(nums[i]);
                flag[i] = true;
                dfs(list, nums, flag);
                flag[i] = false;
                list.removeLast();
            }
        }

    }
}
