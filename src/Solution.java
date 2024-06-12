import java.util.StringJoiner;

class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] split = s.split("\\s+");
        StringJoiner stringJoiner = new StringJoiner(" ");
        for (int i = split.length - 1; i >= 0; i--) {
            stringJoiner.add(split[i]);
        }
        return stringJoiner.toString();
    }
}