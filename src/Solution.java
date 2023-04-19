import java.util.Arrays;

class Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        // i==0
        for (int i = 1; i <= pLen; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        // j==0
        for (int i = 1; i <= sLen; i++) {
            dp[i][0] = false;
        }
        dp[0][0] = true;
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j - 1] || dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && isMatch(s.charAt(i - 1), p.charAt(j - 1));
                }
            }
        }

        // print(dp);

        return dp[sLen][pLen];

    }

    private boolean isMatch(char a, char b) {
        return b == '?' || b == '*' || a == b;
    }

    private void print(boolean[][] arr) {
        for (boolean[] booleans : arr) {
            System.out.println(Arrays.toString(booleans));
        }
    }
}