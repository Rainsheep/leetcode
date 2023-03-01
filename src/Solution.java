import java.util.LinkedList;

class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length - k + 1;
        int[] ans = new int[len];
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.getLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);
        }

        ans[0] = nums[queue.getFirst()];

        for (int i = k; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.getLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);

            while (queue.getFirst() < i - k + 1) {
                queue.removeFirst();
            }
            ans[i - k + 1] = nums[queue.getFirst()];
        }

        return ans;

    }
}