public class Solution240 {

    /**
     * 步进式线性搜索,关键是要意识到矩阵元素的某个特点
     * Runtime: 5 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix II.
     * Memory Usage: 42.9 MB, less than 100.00% of Java online submissions for Search a 2D Matrix II.
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        int i = m - 1, j = 0;
        while (i >= 0 && j < n) {
            if (target == matrix[i][j]){
                return true;
            } else if (target < matrix[i][j]) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }
}
