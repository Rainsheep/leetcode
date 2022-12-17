import java.util.HashMap;

class Solution {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ret = 0;
        int beginIndex = 1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            Integer oldIndex = map.getOrDefault(c, 0);
            beginIndex = Math.max(beginIndex, oldIndex + 1);
            ret = Math.max(ret, i - beginIndex + 1);
            map.put(c, i);
        }
        return ret;

    }
}