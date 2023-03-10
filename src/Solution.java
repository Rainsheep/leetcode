class Solution {

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isNumChar(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            } else if (s.charAt(i) == '[') {
                int closeIndex = findCloseIndex(s, i);
                String sub = s.substring(i + 1, closeIndex);
                String ss = decodeString(sub);
                for (int k = 0; k < num; k++) {
                    sb.append(ss);
                }
                i = closeIndex;
                num = 0;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    private boolean isNumChar(char c) {
        return c >= '0' && c <= '9';
    }

    private int findCloseIndex(String s, int begin) {
        int left = 1;
        for (int i = begin + 1; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                left++;
            } else if (s.charAt(i) == ']') {
                left--;
            }
            if (left == 0) {
                return i;
            }
        }
        return -1;
    }
}