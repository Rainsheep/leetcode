import java.util.ArrayList;

class Solution {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        ArrayList<Integer> list = new ArrayList<>();
        int t = 0;
        int n = num1.length() - 1;
        int m = num2.length() - 1;

        for (int j = m; j >= 0; j--) {
            for (int i = n; i >= 0; i--) {
                int index = (n - i) + (m - j);
                int num = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + t;
                if (index >= list.size()) {
                    t = num / 10;
                    list.add(num % 10);
                } else {
                    num += list.get(index);
                    t = num / 10;
                    list.set(index, num % 10);
                }
            }
            if (t != 0) {
                list.add(t);
                t = 0;
            }
            // System.out.println(list.toString());
        }
        StringBuilder sb = new StringBuilder();
        for (Integer integer : list) {
            sb.append(integer);
        }
        return sb.reverse().toString();

    }

}