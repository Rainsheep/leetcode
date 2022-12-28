class Solution {

    public boolean isNumber(String s) {
        if (isFloat(s) || isInt(s)) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'e' || c == 'E') {
                String s1 = s.substring(0, i);
                String s2 = s.substring(i + 1);
                if ((isFloat(s1) || isInt(s1)) && isInt(s2)) {
                    return true;
                }

            }
        }
        return false;
    }

    private boolean isFloat(String s) {
        if (s.length() == 0) {
            return false;
        }
        int k = 0;
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            k++;
        }
        if (k == s.length()) {
            return false;
        }

        int intNum = 0;
        int pointNum = 0;
        for (; k < s.length(); k++) {
            if (s.charAt(k) == '.') {
                pointNum++;
            } else if (s.charAt(k) >= '0' && s.charAt(k) <= '9') {
                intNum++;
            } else {
                return false;
            }
        }

        return intNum > 0 && pointNum == 1;
    }

    private boolean isInt(String s) {
        if (s.length() == 0) {
            return false;
        }
        int k = 0;
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            k++;
        }
        if (k == s.length()) {
            return false;
        }
        for (; k < s.length(); k++) {
            if (s.charAt(k) < '0' || s.charAt(k) > '9') {
                return false;
            }
        }
        return true;
    }
}