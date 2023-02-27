import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

class Solution {

    boolean ans = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] flag = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            List<Integer> list = map.getOrDefault(prerequisite[0], new ArrayList<>());
            list.add(prerequisite[1]);
            map.put(prerequisite[0], list);
        }

        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            if (flag[key] == 0) {
                dfs(key, map, flag);
            }
        }

        return ans;
    }

    private void dfs(Integer u, HashMap<Integer, List<Integer>> map, int[] flag) {
        flag[u] = 1;
        List<Integer> list = map.get(u);
        if (list != null) {
            for (Integer v : list) {
                if (flag[v] == 0) {
                    dfs(v, map, flag);
                    if (!ans) {
                        return;
                    }
                } else if (flag[v] == 1) {
                    ans = false;
                    return;
                }
            }
        }
        flag[u] = 2;
    }

}