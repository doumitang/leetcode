public class Solution200 {
    int ans = 0;
    // 深度优先
    public int numIslands(char[][] grid) {
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int m = grid.length;
        if (m == 0) return ans;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    recursion(grid, dir, i, j, m, n);
                }
            }
        }
        return ans;
    }

    public void recursion(char[][] grid, int[][] dir, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n) return;
        if (grid[i][j] == '0' || grid[i][j] == '2') return;
        System.out.println("(" + i + ", " + j + ")");
        grid[i][j] = '2';
        recursion(grid, dir, i + dir[0][0], j + dir[0][1], m, n);
        recursion(grid, dir, i + dir[1][0], j + dir[1][1], m, n);
        recursion(grid, dir, i + dir[2][0], j + dir[2][1], m, n);
        recursion(grid, dir, i + dir[3][0], j + dir[3][1], m, n);
    }

    public static void main(String[] args) {
        Solution200 solution200 = new Solution200();
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'1', '1', '1', '1', '1'},
        };
        solution200.numIslands(grid);
    }
}
