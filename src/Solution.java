class Solution {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int t = 0;
        while (aIndex >= 0 || bIndex >= 0) {
            char c1 = aIndex >= 0 ? a.charAt(aIndex) : '0';
            char c2 = bIndex >= 0 ? b.charAt(bIndex) : '0';
            int num = c1 - '0' + c2 - '0' + t;
            t = num / 2;
            sb.append((char) (num % 2 + '0'));
            aIndex--;
            bIndex--;
        }
        if (t != 0) {
            sb.append(t);
        }
        return sb.reverse().toString();

    }
}