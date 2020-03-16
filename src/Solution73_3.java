public class Solution73_3 {

    /**
     * 上一种方法的时间复杂度改进版
     * 第二种方法的低效之处在于，我们可能会重复地设置行或列，即使它已经被设置为零
     * 时间 O(m * n)，空间 O(1)
     * Runtime: 1 ms, faster than 90.43% of Java online submissions for Set Matrix Zeroes.
     * Memory Usage: 42.2 MB, less than 97.14% of Java online submissions for Set Matrix Zeroes.
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        boolean isCol = false; // 用于表示第一列是否需要置为 0
        int R = matrix.length;
        int C = matrix[0].length;

        for (int i = 0; i < R; i++) {
            // Since first cell for both first row and first column is the same i.e. matrix[0][0]
            // We can use an additional variable for either the first row/column.
            // For this solution we are using an additional variable for the first column
            // and using matrix[0][0] for the first row.
            if (matrix[i][0] == 0) {
                isCol = true;
            }
            for (int j = 1; j < C; j++) {
                // If an element is zero, we set the first element of the corresponding row and column to 0
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Iterate over the array once again and using the first row and first column, update the elements.
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // See if the first row needs to be set to zero as well
        if (matrix[0][0] == 0) {
            for (int j = 0; j < C; j++) {
                matrix[0][j] = 0;
            }
        }
        // See if the first column needs to be set to zero as well
        if (isCol) {
            for (int i = 0; i < R; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
