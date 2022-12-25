import java.util.ArrayList;

class Solution {

    public String multiply(String num1, String num2) {
        int m = num2.length() - 1;
        int n = num1.length() - 1;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = n; i >= 0; i--) {
            for (int j = m; j >= 0; j--) {
                int index = n - i + m - j;

                int num = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                if (index < list.size()) {
                    list.set(index, list.get(index) + num);
                } else {
                    list.add(num);
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if (i + 1 < list.size()) {
                list.set(i + 1, list.get(i + 1) + num / 10);
            } else if (num / 10 > 0) {
                list.add(num / 10);
            }
            list.set(i, num % 10);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '0') {
                return sb.substring(i);
            }
        }

        return "0";
    }

    public static void main(String[] args) {
        new Solution().multiply("123", "456");
    }
}