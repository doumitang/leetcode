public class Solution79_2 {
    boolean ans = false;
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    path(board, word, 0, i, j);
                    if (ans) return true;
                }
            }
        }
        return false;
    }

    public void path(char[][] board, String word, int index, int i, int j) {
        if (ans) return;
        if (board[i][j] != word.charAt(index)) return;
        if (index == word.length() - 1) {
            ans = true;
            return;
        }
        char temp = board[i][j];
        board[i][j] = '*';
        int m = board.length, n = board[0].length;
        if (i > 0) path(board, word, index + 1, i - 1, j);
        if (j < n - 1) path(board, word, index + 1, i, j + 1);
        if (i < m - 1) path(board, word, index + 1, i + 1, j);
        if (j > 0) path(board, word, index + 1, i, j - 1);
        board[i][j] = temp;
    }

    public static void main(String[] args) {
        Solution79 solution79 = new Solution79();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        char[][] board1 = {
                {'a', 'b'},
        };
        char[][] board2 = {
                {'C','A','A'},
                {'A','A','A'},
                {'B','C','D'}
        };
        solution79.exist(board1, "ba");
    }
}
