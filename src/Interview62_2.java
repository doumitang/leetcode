public class Interview62_2 {
    /**
     * dp 解法，时间 O(n)，节省空间复杂度到 O(1)
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        int ans = 0; // 长度为 1 的问题肯定是最后留下第 0 个元素
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }
}
