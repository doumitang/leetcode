public class Solution79 {
    //Runtime: 15 ms, beats 21.04%
    //Memory Usage: 40.6 MB
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (word.length() == 1) return true;
                    boolean[][] isVisited = new boolean[m][n];
                    isVisited[i][j] = true;
                    if (path(board, isVisited, word, 1, i, j)) return true;
                }
            }
        }
        return false;
    }

    public boolean path(char[][] board, boolean[][] isVisited, String word, int index, int i, int j) {
        if (index == word.length()) return true;
        int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int m = board.length, n = board[0].length;
        for (int k = 0; k < move.length; k++) {
            int temp_i = i + move[k][0];
            int temp_j = j + move[k][1];
            if (temp_i >= 0 && temp_i < m && temp_j >= 0 && temp_j < n) {
                char c = board[temp_i][temp_j];
                if (!isVisited[temp_i][temp_j] && c == word.charAt(index)) {
                    isVisited[temp_i][temp_j] = true;
                    if (path(board, isVisited, word, index + 1, temp_i, temp_j)) return true;
                    isVisited[temp_i][temp_j] = false;
                }
            }
        }
        return false;
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
