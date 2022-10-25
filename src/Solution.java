import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

class Solution {

    HashSet<List<Integer>> ans = new HashSet<>();
    LinkedList<Integer> list = new LinkedList<>();
    HashSet<Integer> set = new HashSet<>();
    int[] nums = new int[100];
    ArrayList<Integer> numList;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        for (int candidate : candidates) {
            nums[candidate]++;
            set.add(candidate);
        }
        numList = new ArrayList<>(set);

        dfs(0, target, 0);
        return new ArrayList<>(ans);
    }

    private void dfs(int i, int target, int sum) {
        if (sum == target) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (sum > target || i >= numList.size()) {
            return;
        }

        int val = numList.get(i);

        for (int j = 0; j <= nums[val]; j++) {
            for (int k = 0; k < j; k++) {
                list.add(val);
            }

            dfs(i + 1, target, sum + val * j);

            for (int k = 0; k < j; k++) {
                list.removeLast();
            }
        }
    }

}