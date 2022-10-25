import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, 0, target, 0);
        return ans;
    }

    private void dfs(int[] candidates, int i, int target, int sum) {
        if (sum == target) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (sum > target || i >= candidates.length) {
            return;
        }

        list.add(candidates[i]);
        dfs(candidates, i, target, sum + candidates[i]);
        list.removeLast();

        dfs(candidates, i + 1, target, sum);
    }
}