class Solution {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRowFlag = false;
        boolean firstColFlag = false;

        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                firstRowFlag = true;
                break;
            }
        }

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColFlag = true;
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        if (firstRowFlag) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }

        if (firstColFlag) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}