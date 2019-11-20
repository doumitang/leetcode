public class Solution221 {
    /**
     * Runtime: 5 ms, faster than 36.56% of Java online submissions for Maximal Square.
     * Memory Usage: 43.6 MB, less than 78.30% of Java online submissions for Maximal Square.
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int res = 0;
        if (matrix == null) return res;
        int m = matrix.length;
        if (m == 0) return res;
        int n = matrix[0].length;
        if (n == 0) return res;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = (matrix[i][0] == '1') ? 1 : 0;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = (matrix[0][j] == '1') ? 1 : 0;
        }
        if (m > 1 && n > 1) {
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = Math.max(getDpRow(matrix, dp, i, j), getDpColumn(matrix, dp, i, j));
                }
            }
        }
        for (int[] row : dp) {
            for (int val : row) {
                res = Math.max(res, val);
            }
        }
        return res * res;
    }


    private int getDpRow(char[][] matrix, int[][] dp, int i, int j) {
        int size = dp[i - 1][j];
        int leftColumn = j - size + 1, topRow = i - size;
        int count = 0;
        for (int index = j; index >= leftColumn; index--) {
            if (matrix[i][index] == '1') count++;
            else break;
        }
        if (count == size && leftColumn > 0) {
            boolean flag = true;
            for (int k = topRow; k <= i; k++) {
                if (matrix[k][leftColumn - 1] == '0') {
                    flag = false;
                    break;
                }
            }
            return flag ? count + 1 : count;
        }
        return count;
    }

    private int getDpColumn(char[][] matrix, int[][] dp, int i, int j) {
        int size = dp[i][j - 1];
        int leftColumn = j - size, topRow = i - size + 1;
        int count = 0;
        for (int index = i; index >= topRow; index--) {
            if (matrix[index][j] == '1') count++;
            else break;
        }
        if (count == size && topRow > 0) {
            boolean flag = true;
            for (int k = leftColumn; k <= j; k++) {
                if (matrix[topRow - 1][k] == '0') {
                    flag = false;
                    break;
                }
            }
            return flag ? count + 1 : count;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution221 solution221 = new Solution221();
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(solution221.maximalSquare(matrix));
    }
}
