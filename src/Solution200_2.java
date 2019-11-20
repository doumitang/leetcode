import java.util.LinkedList;
import java.util.Queue;

public class Solution200_2 {
    class Element {
        int row, column;
        Element(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public String toString() {
            return "(" + row + ", " + column + ")";
        }
    }
    int ans = 0;
    // 广度优先（队列）
    public int numIslands(char[][] grid) {
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int m = grid.length;
        if (m == 0) return ans;
        int n = grid[0].length;
        Queue<Element> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    grid[i][j] = '2';
                    queue.offer(new Element(i, j));
                    int next_i, next_j;
                    while (!queue.isEmpty()) {
                        Element element = queue.poll();
                        int cur_i = element.row, cur_j = element.column;
                        System.out.println(element.toString());
                        if (cur_i < m - 1) {
                            next_i = cur_i + dir[0][0];
                            next_j = cur_j + dir[0][1];
                            if (grid[next_i][next_j] == '1') {
                                grid[next_i][next_j] = '2';
                                queue.offer(new Element(next_i, next_j));
                            }
                        }
                        if (cur_j < n - 1) {
                            next_i = cur_i + dir[1][0];
                            next_j = cur_j + dir[1][1];
                            if (grid[next_i][next_j] == '1') {
                                grid[next_i][next_j] = '2';
                                queue.offer(new Element(next_i, next_j));
                            }
                        }
                        if (cur_i > 0) {
                            next_i = cur_i + dir[2][0];
                            next_j = cur_j + dir[2][1];
                            if (grid[next_i][next_j] == '1') {
                                grid[next_i][next_j] = '2';
                                queue.offer(new Element(next_i, next_j));
                            }
                        }
                        if (cur_j > 0) {
                            next_i = cur_i + dir[3][0];
                            next_j = cur_j + dir[3][1];
                            if (grid[next_i][next_j] == '1') {
                                grid[next_i][next_j] = '2';
                                queue.offer(new Element(next_i, next_j));
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution200_2 solution200_2 = new Solution200_2();
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'1', '1', '1', '1', '1'},
        };
        solution200_2.numIslands(grid);
    }
}
