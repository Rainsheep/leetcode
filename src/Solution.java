import java.util.ArrayList;

class Solution {

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }

        }

        int resFlag = (dividend ^ divisor) >>> 31 == 1 ? -1 : 1;

        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }

        int ans = 0;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(divisor);
        int t = 1;
        while (dividend - list.get(list.size() - 1) <= list.get(list.size() - 1)) {
            list.add(list.get(list.size() - 1) * 2);
            t <<= 1;
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            if (dividend <= list.get(i)) {
                dividend -= list.get(i);
                ans += t;
            }
            t >>= 1;
        }
        return ans * resFlag;
    }
}