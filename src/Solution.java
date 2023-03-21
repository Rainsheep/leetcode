import java.util.ArrayList;

class Solution {

    public String longestPalindrome(String s) {
        int start = 0, end = -1;
        s = wrapperStr(s);
        ArrayList<Integer> list = new ArrayList<>();
        int right = -1, cid = -1;
        for (int i = 0; i < s.length(); i++) {
            int currentArmLen;
            if (i <= right) {
                int armLen = Math.min(list.get(2 * cid - i), right - i);
                currentArmLen = expand(s, i - armLen, i + armLen);
            } else {
                currentArmLen = expand(s, i, i);
            }
            list.add(currentArmLen);

            if (i + currentArmLen > right) {
                cid = i;
                right = i + currentArmLen;
            }
            if (currentArmLen * 2 + 1 > end - start) {
                start = i - currentArmLen;
                end = i + currentArmLen;
            }
        }

        return getAns(s, start, end);

    }

    private String wrapperStr(String s) {
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        return sb.toString();
    }

    private String getAns(String s, int start, int end) {
        StringBuilder ans = new StringBuilder();
        for (int i = start; i <= end; ++i) {
            if (s.charAt(i) != '#') {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }

    public int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return (right - left - 2) / 2;
    }

    public static void main(String[] args) {
        new Solution().longestPalindrome("babad");
    }

}