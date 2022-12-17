import java.util.ArrayList;
import java.util.List;

class Solution {

    List<String> ans = new ArrayList<>();
    int n;
    int left;
    int right;
    StringBuilder sb = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        this.n = n;
        dfs(sb);
        return ans;
    }

    public void dfs(StringBuilder sb) {
        if (sb.length() == 2 * n) {
            ans.add(sb.toString());
            return;
        }

        if (left < n) {
            sb.append('(');
            left++;
            dfs(sb);

            sb.deleteCharAt(sb.length() - 1);
            left--;
        }

        if (right < left) {
            sb.append(')');
            right++;
            dfs(sb);

            sb.deleteCharAt(sb.length() - 1);
            right--;
        }
    }
}