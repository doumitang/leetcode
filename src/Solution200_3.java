public class Solution200_3 {
    /**
     * 并查集
     * Runtime: 5 ms, faster than 16.45% of Java online submissions for Number of Islands.
     * Memory Usage: 42.2 MB, less than 24.19% of Java online submissions for Number of Islands.
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        UnionFind unionFind = new UnionFind(grid, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        unionFind.union(i * n + j, (i - 1) * n + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        unionFind.union(i * n + j, i * n + j - 1);
                    }
                    if (j + 1 < n && grid[i][j + 1] == '1') {
                        unionFind.union(i * n + j, i * n + j + 1);
                    }
                }
            }
        }
        return unionFind.count;
    }

    public static class UnionFind {
        private int[] parent;
        private int[] weight;
        private int size;
        private int count;

        public UnionFind(char[][] grid, int m, int n) {
            this.size = m * n;
            parent = new int[size];
            weight = new int[size];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') count++;
                    int index = i * n + j;
                    parent[index] = index;
                    weight[index] = 1;
                }
            }
        }

        public int find(int element) {
            if (element != parent[element]) parent[element] = find(parent[element]);
            return parent[element];
        }

        public void union(int firstEle, int secondEle) {
            int firstRoot = find(firstEle);
            int secondRoot = find(secondEle);
            if (firstRoot != secondRoot) {
                if (weight[firstRoot] < weight[secondRoot]) {
                    int temp = firstRoot; firstRoot = secondRoot; secondRoot = temp;
                }
                parent[secondRoot] = firstRoot;
                weight[firstRoot] += weight[secondRoot];
                count--;
            }
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
