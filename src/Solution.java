import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {

    boolean ans = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        LinkedList<Integer> queue = new LinkedList<>();
        int[] in = new int[numCourses];
        int num = 0;
        for (int[] prerequisite : prerequisites) {
            List<Integer> list = map.getOrDefault(prerequisite[0], new ArrayList<>());
            list.add(prerequisite[1]);
            map.put(prerequisite[0], list);
            in[prerequisite[1]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            num++;
            Integer top = queue.pop();
            List<Integer> list = map.get(top);
            if (list != null) {
                for (Integer integer : list) {
                    in[integer]--;
                    if (in[integer] == 0) {
                        queue.add(integer);
                    }
                }
            }
        }

        return num == numCourses;
    }

}