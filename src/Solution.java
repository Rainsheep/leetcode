import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int ans = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int[] interval : intervals) {
            while (!queue.isEmpty() && interval[0] >= queue.peek()) {
                queue.poll();
            }

            queue.add(interval[1]);
            ans = Math.max(ans, queue.size());
        }
        return ans;
    }

    public static void main(String[] args) {
        int res = new Solution().minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}});
        assert res == 2;
        res = new Solution().minMeetingRooms(new int[][]{{7, 10}, {2, 4}});
        assert res == 1;
    }
}
