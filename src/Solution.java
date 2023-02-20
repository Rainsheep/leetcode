import java.util.HashSet;
import java.util.Set;

class Solution {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int ans = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStack = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStack += 1;
                }
                ans = Math.max(ans, currentStack);
            }
        }
        return ans;
    }
}