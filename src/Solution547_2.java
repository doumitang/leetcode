public class Solution547_2 {
    class UnionFind {
        int[] parent;
        int[] height;
        int size;
        int count;

        UnionFind(int size) {
            this.size = size;
            this.count = size;
            parent = new int[size];
            height = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        int find(int element) {
            while (element != parent[element]) {
                parent[element] = parent[parent[element]];
                element = parent[element];
            }
            return element;
        }

        void union(int firstEle, int secondEle) {
            int firstRoot = find(firstEle);
            int secondRoot = find(secondEle);
            if (firstRoot == secondRoot) return;
            if (height[firstRoot] > height[secondRoot]) {
                parent[secondRoot] = firstRoot;
            } else if (height[firstRoot] < height[secondRoot]) {
                parent[firstRoot] = secondRoot;
            } else {
                parent[secondRoot] = firstRoot;
                height[firstRoot]++;
            }
            count--;
        }
    }

    /**
     * 并查集解法（基于高度的合并）
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
}
