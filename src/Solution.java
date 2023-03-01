import java.util.PriorityQueue;

class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length - k + 1;
        int[] ans = new int[len];
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);

        for (int i = 0; i < k; i++) {
            queue.add(new int[]{nums[i], i});
        }

        ans[0] = queue.peek()[0];

        for (int i = k; i < nums.length; i++) {
            queue.add(new int[]{nums[i], i});
            int peek;
            while (queue.peek()[1] <= i - k) {
                queue.poll();
            }
            ans[i - k + 1] = queue.peek()[0];
        }

        return ans;

    }
}