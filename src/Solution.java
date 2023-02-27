import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            in[prerequisite[1]]++;
            List<Integer> list = map.getOrDefault(prerequisite[0], new ArrayList<>());
            list.add(prerequisite[1]);
            map.put(prerequisite[0], list);
        }

        LinkedList<Integer> queue = new LinkedList<>();
        int num = 0;
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer u = queue.pop();
            num++;
            List<Integer> list = map.get(u);
            if (list != null) {
                for (Integer v : list) {
                    in[v]--;
                    if (in[v] == 0) {
                        queue.add(v);
                    }
                }
            }
        }
        return num == numCourses;
    }

    public static void main(String[] args) {
        new Solution().canFinish(2, new int[][]{{0, 1}});
    }

}