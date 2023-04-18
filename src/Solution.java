import java.util.ArrayList;

class Solution {
    public String multiply(String num1, String num2) {
        ArrayList<Integer> ans = new ArrayList<>();
        int num2Len = num2.length();
        int num1Len = num1.length();
        for (int i = num2Len - 1; i >= 0; i--) {
            for (int j = num1Len - 1; j >= 0; j--) {
                int num = (num2.charAt(i) - '0') * (num1.charAt(j) - '0');
                int index = num2Len - 1 - i + num1Len - 1 - j;
                insert(index, num, ans);
            }
        }

        int t = 0;
        for (int i = 0; i < ans.size(); i++) {
            int now = ans.get(i);
            ans.set(i, (now + t) % 10);
            t = (now + t) / 10;
        }

        while (t != 0) {
            ans.add(t % 10);
            t /= 10;
        }

        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (int i = ans.size() - 1; i >= 0; i--) {
            if (flag && ans.get(i) == 0) {
                continue;
            }
            flag = false;
            sb.append(ans.get(i));
        }
        return sb.toString().length() == 0 ? "0" : sb.toString();

    }

    private void insert(int index, int num, ArrayList<Integer> list) {
        if (index == list.size()) {
            list.add(num);
        } else {
            list.set(index, list.get(index) + num);
        }
    }
}