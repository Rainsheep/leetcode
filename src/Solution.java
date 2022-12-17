class Solution {

    public String longestCommonPrefix(String[] strs) {
        String res = strs[0];
        for (String str : strs) {
            res = getPublicPre(res, str);
        }
        return res;
    }

    public String getPublicPre(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < a.length() && index < b.length()) {
            if (a.charAt(index) == b.charAt(index)) {
                sb.append(a.charAt(index++));
            } else {
                break;
            }
        }

        return sb.toString();
    }
}