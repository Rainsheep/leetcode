import java.util.ArrayList;

class Solution {

    public String multiply(String num1, String num2) {
        int m = num2.length() - 1;
        int n = num1.length() - 1;
        int t = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                int index = m - i + n - j;
                int last = index >= list.size() ? 0 : list.get(index);
                int num = (num2.charAt(i) - '0') * (num1.charAt(j) - '0') + t + last;
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
        boolean flag = false;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (!flag && list.get(i) == 0) {
                continue;
            }
            sb.append(list.get(i));
            flag = true;
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}