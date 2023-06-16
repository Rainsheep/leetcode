import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    int ans = 0;
    HashSet<String> set = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        dfs(s, 0, 0, 0, new StringBuilder());
        return new ArrayList<>(set);

    }

    private void dfs(String s, int index, int left, int right, StringBuilder sb) {
        if (s.length() == index) {
            if (left == right) {
                if (sb.length() == ans) {
                    set.add(sb.toString());
                } else if (sb.length() > ans) {
                    ans = sb.length();
                    set.clear();
                    set.add(sb.toString());
                }
            }
            return;
        }

        char c = s.charAt(index);
        if (c != '(' && c != ')') {
            sb.append(c);
            dfs(s, index + 1, left, right, sb);
            sb.deleteCharAt(sb.length() - 1);
        } else if (c == '(') {
            sb.append(c);
            dfs(s, index + 1, left + 1, right, sb);
            sb.deleteCharAt(sb.length() - 1);
        } else if (right < left) {
            sb.append(c);
            dfs(s, index + 1, left, right + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        dfs(s, index + 1, left, right, sb);
    }

    public static void main(String[] args) {
        new Solution().removeInvalidParentheses(")(f");
    }
}