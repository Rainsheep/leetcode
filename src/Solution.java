class Solution {

    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;

        for (int i = 1; i < pLen; i += 2) {
            if (p.charAt(i) == '*') {
                dp[0][i + 1] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (isMatch(s.charAt(i - 1), p.charAt(j - 2))) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }

                } else {
                    dp[i][j] = dp[i - 1][j - 1] && isMatch(s.charAt(i - 1), p.charAt(j - 1));
                }
            }
        }
        return dp[sLen][pLen];
    }


    private boolean isMatch(char sc, char pc) {
        if (pc == '.') {
            return true;
        }
        return sc == pc;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("a", "a*"));
    }
}