import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, Integer> posMap = new HashMap<>();
        ArrayList<List<String>> ans = new ArrayList<>();

        for (String str : strs) {
            Map<Character, Integer> map = getMap(str);
            if (posMap.containsKey(map)) {
                ans.get(posMap.get(map)).add(str);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                ans.add(list);
                posMap.put((HashMap<Character, Integer>) map, ans.size() - 1);
            }
        }

        return ans;
    }

    private Map<Character, Integer> getMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        return map;
    }
}