class Solution {

    public int[] plusOne(int[] digits) {
        int t = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (t == 0) {
                return digits;
            }
            int num = digits[i] + t;
            digits[i] = num % 10;
            t = num / 10;
        }

        if (t != 0) {
            int length = digits.length;
            int[] ans = new int[length + 1];
            ans[0] = 1;
            System.arraycopy(digits, 0, ans, 1, length);
            return ans;
        }

        return digits;

    }
}