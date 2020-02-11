import java.util.ArrayList;
import java.util.List;

public class Solution54 {
    private List<Integer> ans = new ArrayList<>();

    /**
     * 用上下左右标记当前需要打印的矩阵，用一个 flag 标明当前矩阵需要打印的行或者列
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix.
     * Memory Usage: 37.4 MB, less than 5.21% of Java online submissions for Spiral Matrix.
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return ans;
        int n = matrix[0].length;
        recursion(matrix, 0, m - 1, 0, n - 1, 0);
        return ans;
    }

    private void recursion(int[][] matrix, int top, int bottom, int left, int right, int flag) {
        if (top > bottom || left > right) return;
        switch (flag) {
            case 0:
                for (int j = left; j <= right; j++) {
                    ans.add(matrix[top][j]);
                }
                top++;
                break;
            case 1:
                for (int i = top; i <= bottom; i++) {
                    ans.add(matrix[i][right]);
                }
                right--;
                break;
            case 2:
                for (int j = right; j >= left; j--) {
                    ans.add(matrix[bottom][j]);
                }
                bottom--;
                break;
            case 3:
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
                break;
        }
        recursion(matrix, top, bottom, left, right, (flag + 1) % 4);
    }

    public static void main(String[] args) {
        Solution54 solution54 = new Solution54();
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(solution54.spiralOrder(matrix));
    }
}
