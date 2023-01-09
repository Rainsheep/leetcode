class Solution {

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            nums[i][0] = matrix[i][0] - '0';
        }

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                nums[i][j] = matrix[i][j] - '0';
                if (nums[i][j] != 0) {
                    nums[i][j] = nums[i][j - 1] + 1;
                }
            }
        }

        int[][][] minFlag = new int[n][m][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = j; k < m; k++) {
                    int min = nums[j][i];
                    for (int col = j; col <= k; col++) {
                        min = Math.min(min, nums[col][i]);
                    }
                    minFlag[i][j][k] = min;
                }
            }
        }

        int ans = 0;
        for (int col = 0; col < n; col++) {
            for (int x1 = 0; x1 < m; x1++) {
                for (int x2 = x1; x2 < m; x2++) {
                    ans = Math.max(ans, minFlag[col][x1][x2] * (x2 - x1 + 1));
                }
            }
        }
        return ans;
    }
}