import java.util.ArrayList;

class Solution {

    public String longestPalindrome(String s) {
        s = dealStr(s);
        int len = s.length();
        ArrayList<Integer> list = new ArrayList<>(len);
        int cid = -1, right = -1;
        int armLen;
        int begin = 0, end = 0, maxArmLen = 0;
        for (int i = 0; i < len; i++) {
            if (i <= right) {
                armLen = Math.min(list.get(2 * cid - i), right - i + 1);
            } else {
                armLen = 1;
            }
            armLen = expend(s, i - armLen + 1, i + armLen - 1);
            list.add(armLen);

            if (i + armLen - 1 > right) {
                right = i + armLen - 1;
                cid = i;
            }

            if (armLen > maxArmLen) {
                maxArmLen = armLen;
                begin = i - armLen + 1;
                end = i + armLen;
            }

        }

        // System.out.println(list);

        StringBuilder ans = new StringBuilder();
        for (int i = begin; i < end; i++) {
            if (s.charAt(i) != '#') {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }

    private String dealStr(String s) {
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        return sb.toString();
    }

    private int expend(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return (right - left - 1) / 2 + 1;
    }
}