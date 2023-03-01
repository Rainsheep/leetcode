import java.util.Arrays;

class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix.length;
        int n = matrix[0].length;
        for (int[] ints : matrix) {
            if (ints[n - 1] >= target && find(ints, target)) {
                return true;
            }
        }

        return false;
    }

    private boolean find(int[] nums, int target) {
        return Arrays.binarySearch(nums, target) >= 0;
    }
}