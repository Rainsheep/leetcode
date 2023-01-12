import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

class Solution {

    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 1; i <= len - 3 && i <= 3; i++) {
            String s1 = s.substring(0, i);
            if (!check(s1)) {
                continue;
            }
            for (int j = i + 1; j <= len - 2 && j <= i + 3; j++) {
                String s2 = s.substring(i, j);
                if (!check(s2)) {
                    continue;
                }
                for (int k = j + 1; k <= len - 1; k++) {
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k);
                    if (s3.length() > 3 || s4.length() > 3) {
                        continue;
                    }
                    if (check(s3) && check(s4)) {
                        StringJoiner joiner = new StringJoiner(".");
                        joiner.add(s1);
                        joiner.add(s2);
                        joiner.add(s3);
                        joiner.add(s4);
                        ans.add(joiner.toString());
                    }
                }
            }

        }
        return ans;
    }

    private boolean check(String s) {
        if (s.length() > 1 && s.startsWith("0")) {
            return false;
        }

        int k = Integer.parseInt(s);
        return k >= 0 && k <= 255;
    }

    public static void main(String[] args) {
        new Solution().restoreIpAddresses("1231231231234");
    }
}