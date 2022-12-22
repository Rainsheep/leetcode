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
        int num = 1;
        while (dividend - divisor <= divisor) {
            list.add(divisor << 1);
            num <<= 1;
            divisor <<= 1;
        }

        int ans = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (dividend <= list.get(i)) {
                dividend -= list.get(i);
                ans += num;
            }
            num >>= 1;
        }
        return isNegative ? -ans : ans;
    }
}