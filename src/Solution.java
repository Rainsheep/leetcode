import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(value -> value[0]));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int[] interval : intervals) {
            if (!queue.isEmpty() && interval[0] >= queue.peek()) {
                queue.poll();
            }
            queue.add(interval[1]);
        }
        return queue.size();
    }

    public static void main(String[] args) {
        int res = new Solution().minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}});
        System.out.println(res == 2);
        res = new Solution().minMeetingRooms(new int[][]{{7, 10}, {2, 4}});
        System.out.println(res == 1);
    }
}
