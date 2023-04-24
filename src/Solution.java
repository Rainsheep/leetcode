import java.util.HashMap;
import java.util.HashSet;

class Solution {

    public String minWindow(String s, String t) {
        int n = 52;
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        int begin = 0;
        int end = 0;
        String ans = "";
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) - 1);
            set.add(c);
        }

        for (int i = 0; i < s.length(); i++) {
            // add
            end = i + 1;
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int newValue = map.get(c) + 1;
                map.put(c, newValue);
                if (newValue == 0) {
                    set.remove(c);
                }
            }
            // from head delete
            while (set.isEmpty()) {
                // update result
                if (ans.length() == 0 || end - begin < ans.length()) {
                    ans = s.substring(begin, end);
                }

                char beginC = s.charAt(begin);
                if (map.containsKey(beginC)) {
                    int newValue = map.get(beginC) - 1;
                    map.put(beginC, newValue);
                    if (newValue == -1) {
                        set.add(beginC);
                    }
                }
                begin++;
            }

        }

        return ans;
    }

}