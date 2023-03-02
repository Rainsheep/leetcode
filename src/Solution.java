import java.util.LinkedList;

class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.removeLast();
            }
            queue.add(i);
        }
        res[0] = nums[queue.peek()];
        for (int i = k; i < len; i++) {
            if (queue.peek() < i - k + 1) {
                queue.pop();
            }
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.removeLast();
            }
            queue.add(i);

            res[i - k + 1] = nums[queue.peek()];
        }

        return res;


    }
}