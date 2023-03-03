import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {

    HashSet<String> ans = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {

        int lremove = 0;
        int rremove = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lremove++;
            } else if (s.charAt(i) == ')') {
                if (lremove > 0) {
                    lremove--;
                } else {
                    rremove++;
                }
            }
        }
        tryDelete(s, 0, lremove, rremove);

        return new ArrayList<>(ans);
    }

    private void tryDelete(String s, int start, int lremove, int rremove) {
        if (lremove == 0 && rremove == 0) {
            if (isVail(s)) {
                ans.add(s);
            }
            return;
        }

        if (s.length() - start < lremove + rremove) {
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (i != start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }

            if (s.charAt(i) == '(' && lremove > 0) {
                tryDelete(s.substring(0, i) + s.substring(i + 1), i, lremove - 1, rremove);
            }

            if (s.charAt(i) == ')' && rremove > 0) {
                tryDelete(s.substring(0, i) + s.substring(i + 1), i, lremove, rremove - 1);
            }
        }
    }


    private boolean isVail(String s) {
        int lNum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lNum++;
            } else if (s.charAt(i) == ')') {
                if (lNum == 0) {
                    return false;
                }
                lNum--;
            }
        }
        return lNum == 0;
    }
}