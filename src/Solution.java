class Solution {

    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        while (left <= right) {
            long mid = (left + right) / 2;
            long t = mid * mid;
            if (t == x) {
                return (int) mid;
            } else if (t > x) {
                right = (int) (mid - 1);
            } else {
                left = (int) (mid + 1);
            }
        }
        return right;
    }

}