class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
            return false;
        }

        int left = 0;
        int right = m - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        int k = right;
        left = 0;
        right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[k][mid] == target) {
                return true;
            } else if (matrix[k][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}