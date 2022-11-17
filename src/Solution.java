class Solution {

    public int lengthOfLastWord(String s) {
        int ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (ans == 0) {
                    continue;
                }
                break;
            }
            ans++;
        }
        return ans;
    }
}