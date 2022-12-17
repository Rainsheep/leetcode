class Solution {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        if (x % 10 == 0) {
            return false;
        }
        return x == reverse(x);
    }

    private long reverse(long x) {
        long ret = 0;
        while (x != 0) {
            ret = ret * 10 + x % 10;
            x /= 10;
        }
        return ret;
    }
}