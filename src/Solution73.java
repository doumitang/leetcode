public class Solution73 {
    /**
     * 元素 (i, j) 为 0 代表第 i 行和第 j 列上的元素都应为 0
     * 时间 O(m * n)，空间 O(m + n)
     * Runtime: 1 ms, faster than 90.43% of Java online submissions for Set Matrix Zeroes.
     * Memory Usage: 41.7 MB, less than 97.14% of Java online submissions for Set Matrix Zeroes.
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        if (matrix == null) return;
        int m = matrix.length;
        if (m == 0) return;
        int n = matrix[0].length;
        boolean[] rowRecord = new boolean[m];
        boolean[] columnRecord = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowRecord[i] = true;
                    columnRecord[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (rowRecord[i]) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            if (columnRecord[j]) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
