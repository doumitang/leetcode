import java.util.Arrays;

public class Solution48 {
    public void rotate(int[][] matrix) {
        recursion(matrix, 0, matrix.length - 1, 0, matrix.length - 1);
    }

    private void recursion(int[][] matrix, int row, int rowEnd, int column, int columnEnd) {
        if (row >= rowEnd) return;
//        System.out.println("" + column + " " + columnEnd);
        int length = rowEnd - row + 1;
        for (int j = 0; j < length - 1; j++) {
//            System.out.println("" + row + " " + j + " ");
            int curColumn = column + j;
            int temp = matrix[row][curColumn];
            matrix[row][curColumn] = matrix[rowEnd - j][column];
            matrix[rowEnd - j][column] = matrix[rowEnd][columnEnd - j];
            matrix[rowEnd][columnEnd - j] = matrix[curColumn][columnEnd];
            matrix[curColumn][columnEnd] = temp;
        }
        recursion(matrix, row + 1, rowEnd - 1, column + 1, columnEnd - 1);
    }

    public static void main(String[] args) {
        Solution48 solution48 = new Solution48();
        int[][] matrix3 = new int[][]{
                {5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}
        };
        int[][] matrix1 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] matrix2 = new int[][]{
                {2,29,20,26,16,28},
                {12,27,9,25,13,21},
                {32,33,32,2,28,14},
                {13,14,32,27,22,26},
                {33,1,20,7,21,7},
                {4,24,1,6,32,34}
        };
        solution48.rotate(matrix3);
        System.out.println(Arrays.deepToString(matrix3));
    }
}
