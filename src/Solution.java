import java.util.ArrayList;

class Solution {

    public String multiply(String num1, String num2) {
        int m = num2.length() - 1;
        int n = num1.length() - 1;
        ArrayList<Integer> list = new ArrayList<>();
        int t = 0, num;
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                int index = m - i + n - j;
                int old = list.size() > index ? list.get(index) : 0;
                num = (num2.charAt(i) - '0') * (num1.charAt(j) - '0') + t + old;
                t = num / 10;
                num = num % 10;
                if (list.size() > index) {
                    list.set(index, num);
                } else {
                    list.add(num);
                }
            }
            if (t != 0) {
                list.add(t);
                t = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }

        int begin = 0;
        while (begin < sb.length() && sb.charAt(begin) == '0') {
            begin++;
        }
        if (begin == sb.length()) {
            return "0";
        }
        return sb.substring(begin);

    }
}