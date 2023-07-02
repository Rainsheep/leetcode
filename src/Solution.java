import java.util.ArrayList;

class Solution {

    public int countSubstrings(String s) {
        int ans = 0;
        s = wrapperStr(s);
        int cid = -1, right = -1;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 1; i < s.length() - 1; i++) {
            int armLen = i <= right ? Math.min(list.get(2 * cid - i), right - i + 1) : 1;
            while (s.charAt(i + armLen) == s.charAt(i - armLen)) {
                armLen++;
            }
            list.add(armLen);

            if (i + armLen - 1 > right) {
                cid = i;
                right = i + armLen - 1;
            }

            // System.out.println(i + " " + armLen / 2);
            ans += armLen / 2;
        }

        return ans;
    }

    public String wrapperStr(String s) {
        StringBuilder sb = new StringBuilder("^#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        sb.append("$");
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countSubstrings("aba"));
    }
}