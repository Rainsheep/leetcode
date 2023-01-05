import java.util.HashMap;
import java.util.Map;

class Solution {

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> flagMap = new HashMap<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int sLen = s.length();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            flagMap.put(c, flagMap.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = -1;
        int lAns = 0;
        int rAns = 0;
        while (true) {
            if (check(flagMap, map)) {
                if (rAns == 0 || right - left + 1 < rAns - lAns) {
                    lAns = left;
                    rAns = right + 1;
                }
                char c = s.charAt(left);
                map.put(c, map.get(c) - 1);
                left++;
            } else {
                right++;
                if (right == sLen) {
                    break;
                }
                char c = s.charAt(right);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        return s.substring(lAns, rAns);

    }

    private boolean check(Map<Character, Integer> flagMap, Map<Character, Integer> map) {
        for (Character c : flagMap.keySet()) {
            if (map.getOrDefault(c, 0) < flagMap.get(c)) {
                return false;
            }
        }
        return true;
    }
}