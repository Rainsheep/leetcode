import java.util.ArrayList;
import java.util.List;

class Solution {

    ArrayList<String> ans = new ArrayList<>();
    List<String> chars;

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return ans;
        }
        chars = new ArrayList<String>() {
            {
                add("");
                add("");
                add("abc");
                add("def");
                add("ghi");
                add("jkl");
                add("mno");
                add("pqrs");
                add("tuv");
                add("wxyz");
            }
        };
        dfs(digits, 0, new StringBuilder());
        return ans;

    }

    private void dfs(String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            ans.add(new String(sb));
            return;
        }

        int t = digits.charAt(index) - '0';
        String s = chars.get(t);
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            dfs(digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}