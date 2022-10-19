import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> ans = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int oneLength = words[0].length();
        int sumLength = oneLength * words.length;

        if (s.length() < sumLength) {
            return ans;
        }

        for (int i = 0; i + sumLength <= s.length(); i++) {
            if (match(s.substring(i, i + sumLength), new HashMap<>(map), oneLength)) {
                ans.add(i);
            }
        }

        return ans;

    }

    public boolean match(String s, Map<String, Integer> map, int oneLength) {
        int index = 0;
        while (index != s.length()) {
            String st = s.substring(index, index + oneLength);
            if (map.containsKey(st)) {
                int leftNum = map.get(st) - 1;
                if (leftNum != 0) {
                    map.put(st, leftNum);
                } else {
                    map.remove(st);
                }
                index += oneLength;
                continue;
            }

            return false;
        }
        return true;
    }
}