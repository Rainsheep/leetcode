import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] outCount = new int[numCourses];
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        int count = 0;

        for (int[] prerequisite : prerequisites) {
            outCount[prerequisite[0]]++;
            HashSet<Integer> set = map.computeIfAbsent(prerequisite[1], k -> new HashSet<>());
            set.add(prerequisite[0]);
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (outCount[i] == 0) {
                queue.add(i);
            }
        }

        while (true) {
            if (queue.isEmpty()) {
                return count == numCourses;
            }

            Integer head = queue.pop();
            HashSet<Integer> set = map.get(head);
            if (set != null && set.size() != 0) {
                for (Integer num : set) {
                    outCount[num]--;
                    if (outCount[num] == 0) {
                        queue.add(num);
                    }
                }
            }
            count++;

        }

    }
}