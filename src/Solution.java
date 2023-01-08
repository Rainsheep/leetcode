import java.util.HashMap;

class Solution {

    HashMap<Character, Integer> flagMap = new HashMap<>();
    HashMap<Character, Integer> map = new HashMap<>();

    public String minWindow(String s, String t) {
        int leftAns = 0;
        int rightAns = 0;

        int left = 0;
        int right = 0;

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            flagMap.put(c, flagMap.getOrDefault(c, 0) + 1);
        }

        while (right != s.length() + 1) {
            if (check()) {
                if (rightAns == 0 || right - left < rightAns - leftAns) {
                    leftAns = left;
                    rightAns = right;
                }
                char c = s.charAt(left);
                map.put(c, map.getOrDefault(c, 1) - 1);
                left++;
            } else {
                if (right == s.length()) {
                    break;
                }
                char c = s.charAt(right);
                map.put(c, map.getOrDefault(c, 0) + 1);
                right++;
            }
        }
        return s.substring(leftAns, rightAns);
    }

    private boolean check() {
        for (Character c : flagMap.keySet()) {
            if (map.getOrDefault(c, 0) < flagMap.get(c)) {
                return false;
            }
        }
        return true;
    }
}