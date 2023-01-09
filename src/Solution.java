import java.util.HashMap;
import java.util.Map;

class Solution {

    Map<String, Map<String, Boolean>> flagMap = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        return dfs(s1, s2);
    }

    private boolean dfs(String s1, String s2) {
        Boolean mapRet = getMapRet(s1, s2);
        if (mapRet != null) {
            return mapRet;
        }

        if (s1.equals(s2)) {
            putMap(s1, s2, true);
            return true;
        }
        int len = s1.length();
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        HashMap<Character, Integer> map3 = new HashMap<>();
        for (int i = 0; i < len - 1; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            char c3 = s2.charAt(len - 1 - i);
            map1.put(c1, map1.getOrDefault(c1, 0) + 1);
            map2.put(c2, map2.getOrDefault(c2, 0) + 1);
            map3.put(c3, map3.getOrDefault(c3, 0) + 1);

            if (map1.equals(map2)) {
                boolean ret1 = dfs(s1.substring(0, i + 1), s2.substring(0, i + 1));
                boolean ret2 = dfs(s1.substring(i + 1), s2.substring(i + 1));
                if (ret1 && ret2) {
                    putMap(s1, s2, true);
                    return true;
                }
            }

            if (map1.equals(map3)) {
                boolean ret1 = dfs(s1.substring(0, i + 1), s2.substring(len - i - 1, len));
                boolean ret2 = dfs(s1.substring(i + 1), s2.substring(0, len - i - 1));
                if (ret1 && ret2) {
                    putMap(s1, s2, true);
                    return true;
                }
            }

        }
        putMap(s1, s2, false);
        return false;

    }

    private Boolean getMapRet(String s1, String s2) {
        Map<String, Boolean> map = flagMap.get(s1);
        if (map == null) {
            return null;
        }
        return map.get(s2);
    }

    private void putMap(String s1, String s2, boolean ret) {
        Map<String, Boolean> map = flagMap.getOrDefault(s1, new HashMap<>());
        map.put(s2, ret);
        flagMap.put(s1, map);
    }
}