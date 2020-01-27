import java.util.HashMap;
import java.util.Map;

public class Solution128_3 {
    /**
     * 并查集法，时间接近O(n)，空间为O(n)
     * Runtime: 12 ms, faster than 19.27% of Java online submissions for Longest Consecutive Sequence.
     * Memory Usage: 42.3 MB, less than 5.17% of Java online submissions for Longest Consecutive Sequence.
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        int len = nums.length;
        UnionFind unionFind = new UnionFind(len);
        Map<Integer, Integer> map = new HashMap<>(); // 存放已经处理过的元素
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])) continue;
            map.put(nums[i], i);
            int left = map.getOrDefault(nums[i] - 1, i);
            int right = map.getOrDefault(nums[i] + 1, i);
            unionFind.union(left, i);
            unionFind.union(i, right);
        }
        return unionFind.ans;
    }

    public static class UnionFind {
        private int[] parent;
        private int[] weight;
        private int size;
        private int count;
        private int ans;

        public UnionFind(int size) {
            ans = 1;
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
                    int temp = firstRoot; firstRoot = secondRoot; secondRoot = temp;
                }
                parent[secondRoot] = firstRoot;
                weight[firstRoot] += weight[secondRoot];
                ans = Math.max(ans, weight[firstRoot]);
                count--;
            }
        }
    }
}
