import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> lists = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        int nowLen = 0;
        for (String word : words) {
            int newLen;
            if (nowLen == 0) {
                newLen = word.length();
            } else {
                newLen = nowLen + word.length() + 1;
            }

            if (newLen <= maxWidth) {
                temp.add(word);
                nowLen = newLen;
            } else {
                lists.add(temp);
                temp = new ArrayList<>();
                temp.add(word);
                nowLen = word.length();
            }

        }

        lists.add(temp);

        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++) {
            ans.add(convert(lists.get(i), maxWidth, i == lists.size() - 1));
        }
        return ans;


    }


    private String convert(List<String> list, int maxWidth, boolean left) {
        StringBuilder sb = new StringBuilder();
        if (list.size() == 1) {
            sb.append(list.get(0));
            int spaceNum = maxWidth - list.get(0).length();
            sb.append(" ".repeat(Math.max(0, spaceNum)));
            return sb.toString();
        }

        if (left) {
            for (String s : list) {
                if (sb.length() != 0) {
                    sb.append(' ');
                }
                sb.append(s);
            }

            int spaceNum = maxWidth - sb.length();
            sb.append(" ".repeat(Math.max(0, spaceNum)));
            return sb.toString();
        }

        int sumLen = 0;
        for (String s : list) {
            sumLen += s.length();
        }
        int spaceNum = maxWidth - sumLen;
        int avgSpaceNum = spaceNum / (list.size() - 1);
        int leftSpaceNum = (spaceNum - avgSpaceNum * (list.size() - 1));
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                sb.append(list.get(i));
            } else {
                if (leftSpaceNum > 0) {
                    sb.append(' ');
                    leftSpaceNum--;
                }
                sb.append(" ".repeat(avgSpaceNum));
                sb.append(list.get(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new Solution().convert(List.of("science", "is", "what", "we"), 20, false);
    }

}