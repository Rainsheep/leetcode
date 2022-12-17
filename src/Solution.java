class Solution {

    public int myAtoi(String s) {
        s = s.trim();
        int flag = 1;
        if (s.length() == 0) {
            return 0;
        }

        if (s.charAt(0) == '-') {
            flag = -1;
            s = s.substring(1);
        } else if (s.charAt(0) == '+') {
            s = s.substring(1);
        }

        long res = 0;
        int index = 0;
        while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
            res = res * 10 + s.charAt(index) - '0';
            index++;

            if (res * flag > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (res * flag < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        res = res * flag;

        return (int) res;
    }
}