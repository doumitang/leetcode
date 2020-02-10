import java.util.HashSet;
import java.util.Set;

public class Solution36 {
    private Set<Character> set = new HashSet<>();

    /**
     * 按题目给的三点 rule 进行检查，使用 HashSet，时间 O(n ^ 2)，空间 O(n ^ 2)虽然 n ^ 2 / 9 == n
     * Runtime: 3 ms, faster than 69.62% of Java online submissions for Valid Sudoku.
     * Memory Usage: 41 MB, less than 97.10% of Java online submissions for Valid Sudoku.
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        return validateRows(board) && validateCols(board) && validateSub(board);
    }

    private boolean validateRows(char[][] board) {
        set.clear();
        for (int i = 0; i < 9; i++) {
            set.clear();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                if (set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }
        return true;
    }

    private boolean validateCols(char[][] board) {
        set.clear();
        for (int j = 0; j < 9; j++) {
            set.clear();
            for (int i = 0; i < 9; i++) {
                if (board[i][j] == '.') continue;
                if (set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }
        return true;
    }

    private boolean validateSub(char[][] board) {
        set.clear();
        for (int count_i = 0; count_i < 3; count_i++) {
            for (int count_j = 0; count_j < 3; count_j++) {
                set.clear();
                for (int i = count_i * 3; i < (count_i + 1) * 3; i++) {
                    for (int j = count_j * 3; j < (count_j + 1) * 3; j++) {
                        if (board[i][j] == '.') continue;
                        if (set.contains(board[i][j])) return false;
                        set.add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution36 solution36 = new Solution36();
        char[][] board = {
    {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
	{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
	{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
	{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
	{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
	{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
	{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
	{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
	{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(solution36.isValidSudoku(board));
    }
}
