import java.util.Arrays;

class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix.length;
        for (int[] ints : matrix) {
            if (find(ints, target)) {
                return true;
            }
        }

        return false;
    }

    private boolean find(int[] nums, int target) {
        return Arrays.binarySearch(nums, target) >= 0;
    }
}