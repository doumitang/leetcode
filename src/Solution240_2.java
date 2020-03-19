public class Solution240_2 {
    /**
     * 分治法，分解成4个子问题，取其中两个
     * Runtime: 5 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix II.
     * Memory Usage: 40.5 MB, less than 100.00% of Java online submissions for Search a 2D Matrix II.
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        return recursion(matrix, target, 0, 0, m - 1, n - 1);
    }

    private boolean recursion(int[][] matrix, int target, int x1, int y1, int x2, int y2) {
        if (x1 > x2 || y1 > y2) return false;
        if (target < matrix[x1][y1] || target > matrix[x2][y2]) return false;
        int midRow = (x1 + x2) / 2;
        int left = y1, right = y2;
        while (left < right) {
            int midColumn = (left + right) / 2;
            // 找到第一个比target大的元素
            if (matrix[midRow][midColumn] >= target) {
                right = midColumn;
            } else {
                left = midColumn + 1;
            }
        }
        if (matrix[midRow][left] == target) return true;
        // 如果找不到第一个比target大的元素
        if (matrix[midRow][left] < target) left++;
        return recursion(matrix, target, x1, left, midRow - 1, y2) || recursion(matrix, target, midRow + 1, y1, x2, left - 1);
    }

    public static void main(String[] args) {
        Solution240_2 solution240_2 = new Solution240_2();
        int[][] matrix = {{5, 6}};
        System.out.println(solution240_2.searchMatrix(matrix, 6));
    }
}
