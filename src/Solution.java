import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int index = Arrays.binarySearch(intervals, newInterval, Comparator.comparingInt(value -> value[0]));
        if (index < 0) {
            index = -index - 1;
        }
        int[][] res = new int[intervals.length + 1][2];
        for (int i = 0; i < index; i++) {
            res[i] = intervals[i];
        }
        res[index] = newInterval;
        for (int i = index; i < intervals.length; i++) {
            res[i + 1] = intervals[i];
        }
        return merge(res);
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        ArrayList<int[]> res = new ArrayList<>();
        int begin = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                res.add(new int[]{begin, end});
                begin = intervals[i][0];
                end = intervals[i][1];
            } else {
                end = Math.max(end, intervals[i][1]);
            }
        }
        res.add(new int[]{begin, end});
        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}