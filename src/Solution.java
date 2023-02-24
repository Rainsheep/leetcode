import java.util.HashSet;

class Solution {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;
        for (int num : nums) {
            int len = 1;
            int nowNum = num;
            while (set.contains(nowNum + 1)) {
                len++;
                nowNum++;
            }
            res = Math.max(res, len);
        }
        return res;
    }
}