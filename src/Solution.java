import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {

            if (i < k) {
                addToQueue(queue, nums, i);
                continue;
            }

            ans[i - k] = nums[queue.getFirst()];
            addToQueue(queue, nums, i);
            if (queue.getFirst() == i - k) {
                queue.removeFirst();
            }
        }
        ans[ans.length - 1] = nums[queue.getFirst()];
        return ans;
    }

    private void addToQueue(LinkedList<Integer> queue, int[] nums, int index) {
        while (!queue.isEmpty() && nums[index] >= nums[queue.getLast()]) {
            queue.removeLast();
        }
        queue.add(index);
    }
}