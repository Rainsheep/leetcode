import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                left = Math.max(map.get(c) + 1, left);
            }
            ans = Math.max(ans, i - left + 1);
            map.put(c, i);
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution().lengthOfLongestSubstring("abba");
    }
}