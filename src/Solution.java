import java.util.HashMap;

class Solution {

    HashMap<Character, int[]> map = new HashMap<>();

    public int leastInterval(char[] tasks, int n) {
        int N = 26;
        int count = 0;
        int max = 0;
        char[] nums = new char[N];
        for (char task : tasks) {
            int index = task - 'A';
            nums[index]++;

            if (nums[index] > max) {
                max = nums[index];
                count = 1;
            } else if (nums[index] == max) {
                count++;
            }
        }

        return Math.max((max - 1) * (n + 1) + count, tasks.length);
    }

}