class Solution {

    int[][] flag;

    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        flag = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (isVail(s, j, i)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean isVail(String s, int begin, int end) {
        if (flag[begin][end] == 1) {
            return true;
        }
        if (flag[begin][end] == 2) {
            return false;
        }

        if (end <= begin) {
            if (begin == end) {
                flag[begin][end] = 1;
            }
            return true;
        }

        boolean b = s.charAt(begin) == s.charAt(end);
        if (!b) {
            flag[begin][end] = 2;
            return false;
        }
        flag[begin][end] = isVail(s, begin + 1, end - 1) ? 1 : 2;
        return flag[begin][end] == 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countSubstrings("ab"));
    }
}