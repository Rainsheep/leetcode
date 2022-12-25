import java.util.ArrayList;

class Solution {

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isNegative = (((dividend ^ divisor) >> 31) & 1) == 1;
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(divisor);
        int res = 1;
        while (dividend - list.get(list.size() - 1) <= list.get(list.size() - 1)) {
            list.add(list.get(list.size() - 1) << 1);
            res <<= 1;
        }

        int ans = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (dividend <= list.get(i)) {
                dividend -= list.get(i);
                ans += res;
            }
            res >>= 1;
        }
        return isNegative ? -ans : ans;

    }
}