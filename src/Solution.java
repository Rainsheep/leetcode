class Solution {

    public double myPow(double x, int n) {
        boolean isNegative = false;
        long m = n;
        if (m < 0) {
            isNegative = true;
            m = -m;
        }

        double ans = 1;
        double res = x;
        while (m != 0) {
            if ((m & 1) == 1) {
                ans *= res;
            }
            res *= res;
            m >>= 1;
        }

        return isNegative ? 1.0 / ans : ans;

    }

}