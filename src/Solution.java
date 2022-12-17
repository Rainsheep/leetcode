class Solution {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int index = i;
            while (index < s.length()) {
                sb.append(s.charAt(index));
                if (i != 0 && i != numRows - 1 && index + 2 * numRows - 2 * i - 2 < s.length()) {
                    sb.append(s.charAt(index + 2 * numRows - 2 * i - 2));
                }
                index += 2 * numRows - 2;
            }
        }

        return sb.toString();

    }
}