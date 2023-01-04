import java.util.HashMap;

class Solution {

    HashMap<Character, Integer> flagMap = new HashMap<>();
    HashMap<Character, Integer> map = new HashMap<>();

    public String minWindow(String s, String t) {

        int tLen = t.length();
        int sLen = s.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            flagMap.put(c, flagMap.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = -1;

        int lAns = 0;
        int rAns = 0;
        while (true) {
            if (check()) {
                // flag
                if (rAns == 0 || right + 1 - left < rAns - lAns) {
                    lAns = left;
                    rAns = right + 1;
                }

                // delete left
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


    private boolean check() {
        for (Character character : flagMap.keySet()) {
            if (map.getOrDefault(character, 0) < flagMap.get(character)) {
                return false;
            }
        }
        return true;
    }
}