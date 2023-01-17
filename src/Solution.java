import java.util.HashMap;

class Solution {

    HashMap<Character, Integer> flagMap = new HashMap<>();
    HashMap<Character, Integer> map = new HashMap<>();

    public String minWindow(String s, String t) {

        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            flagMap.put(c, flagMap.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = -1;
        int leftAns = 0;
        int rightAns = -1;
        while (true) {
            while (check()) {
                if (rightAns == -1 || right - left < rightAns - leftAns) {
                    leftAns = left;
                    rightAns = right;
                }

                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }

            right++;
            if (right == s.length()) {
                break;
            }
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
        }

        return s.substring(leftAns, rightAns + 1);
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