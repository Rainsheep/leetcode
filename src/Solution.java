import java.util.ArrayList;

class Solution {

    public String multiply(String num1, String num2) {
        int m = num2.length() - 1;
        int n = num1.length() - 1;
        ArrayList<Integer> list = new ArrayList<>();
        int t = 0;
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                int index = m - i + n - j;
                int old = index >= list.size() ? 0 : list.get(index);
                int num = (num2.charAt(i) - '0') * (num1.charAt(j) - '0') + t + old;
                t = num / 10;
                if (index >= list.size()) {
                    list.add(num % 10);
                } else {
                    list.set(index, num % 10);
                }
            }
            list.add(t);
            t = 0;
        }

        StringBuilder sb = new StringBuilder();
        for (Integer integer : list) {
            sb.append(integer);
        }
        sb = sb.reverse();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '0') {
                return sb.substring(i);
            }
        }
        return "0";
    }
}