public class Solution73_2 {
    /**
     * 用特殊值做标记，可以节省空间复杂度
     * 时间 O(m * n * (m + n))，空间 O(1)
     * Runtime: 1 ms, faster than 90.43% of Java online submissions for Set Matrix Zeroes.
     * Memory Usage: 42.8 MB, less than 95.71% of Java online submissions for Set Matrix Zeroes.
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        if (matrix == null) return;
        int m = matrix.length;
        if (m == 0) return;
        int n = matrix[0].length;
        int MODIFIED = -1000000; // 特殊值定义
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    for (int index = 0; index < n; index++) {
                        if (matrix[i][index] != 0) {
                            matrix[i][index] = MODIFIED;
                        }
                    }
                    for (int index = 0; index < m; index++) {
                        if (matrix[index][j] != 0) {
                            matrix[index][j] = MODIFIED;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == MODIFIED) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution73_2 solution73_2 = new Solution73_2();
        int[][] matrix = {

                {1,1,1},{1,0,1},{1,1,1}
        };
        solution73_2.setZeroes(matrix);
    }
}
