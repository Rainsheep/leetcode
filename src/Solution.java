class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {
        int s3Len = s3.length();
        int s1Len = s1.length();
        int s2Len = s2.length();
        if (s1Len + s2Len != s3Len) {
            return false;
        }
        boolean[] dp = new boolean[s2Len + 1];

        for (int i = 0; i <= s1Len; i++) {
            for (int j = 0; j <= s2Len; j++) {
                int p = i + j - 1;
                if (i == 0 && j == 0) {
                    dp[j] = true;
                } else if (i == 0) {
                    dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(p);
                } else if (j == 0) {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(p);
                } else {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(p) || dp[j - 1] && s2.charAt(j - 1) == s3.charAt(p);
                }
            }
        }
        return dp[s2Len];
    }
}