import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        int pLen = p.length();
        int sLen = s.length();
        ArrayList<Integer> ans = new ArrayList<>();
        if (pLen > sLen) {
            return ans;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < pLen; i++) {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        for (int i = 0; i < pLen; i++) {
            char c = s.charAt(i);
            Integer num = map.getOrDefault(c, 0);
            if (num == -1) {
                map.remove(c);
            } else {
                map.put(c, num + 1);
            }
        }
        if (map.isEmpty()) {
            ans.add(0);
        }

        for (int i = pLen; i < sLen; i++) {
            char c = s.charAt(i);
            Integer num = map.getOrDefault(c, 0);
            if (num == -1) {
                map.remove(c);
            } else {
                map.put(c, num + 1);
            }

            char oldC = s.charAt(i - pLen);
            num = map.getOrDefault(oldC, 0);
            if (num == 1) {
                map.remove(oldC);
            } else {
                map.put(oldC, num - 1);
            }

            if (map.isEmpty()) {
                ans.add(i - pLen + 1);
            }
        }

        return ans;
    }
}