import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    ArrayList<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        dfs(0, nums, list);
        return ans;
    }

    private void dfs(int index, int[] nums, LinkedList<Integer> list) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        dfs(index + 1, nums, list);

        list.add(nums[index]);
        dfs(index + 1, nums, list);
        list.removeLast();
    }
}