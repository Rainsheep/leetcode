class Solution {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                swap(matrix, i, j, j, i);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                swap(matrix, i, j, i, n - j - 1);
            }
        }

    }

    private void swap(int[][] num, int x1, int y1, int x2, int y2) {
        int t = num[x1][y1];
        num[x1][y1] = num[x2][y2];
        num[x2][y2] = t;

    }
}