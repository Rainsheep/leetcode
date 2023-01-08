import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    ArrayList<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        dfs(1, k, n, list);
        return ans;
    }

    private void dfs(int now, int k, int n, LinkedList<Integer> list) {
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (now == n + 1) {
            return;
        }

        list.add(now);
        dfs(now + 1, k, n, list);
        list.removeLast();
        dfs(now + 1, k, n, list);
    }
}