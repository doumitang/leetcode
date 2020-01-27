public class Solution547 {

    /**
     * 并查集解法（基于重量的合并与路径压缩）
     * Runtime: 1 ms, faster than 99.88% of Java online submissions for Friend Circles. （时间不稳定，经常会到 2ms）
     * Memory Usage: 42.3 MB, less than 56.00% of Java online submissions for Friend Circles.
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind unionFind = new UnionFind(n);
        // 只需要遍历右上半个矩阵
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) {
                    unionFind.union(i, j);
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

        public UnionFind(int size) {
            this.size = size;
            this.count = size;
            parent = new int[size];
            weight = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                weight[i] = 1;
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
                    int temp = firstRoot;
                    firstRoot = secondRoot;
                    secondRoot = temp;
                }
                parent[secondRoot] = firstRoot;
                weight[firstRoot] += weight[secondRoot];
                count--;
            }
        }
    }
}
