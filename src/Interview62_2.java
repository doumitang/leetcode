public class Interview62_2 {
    /**
     * dp 解法，长度为 n 的问题的解本应该等于删掉第一个元素以后，长度为 n - 1 的问题的解
     * 但是关键在于序号的对应关系
     * 时间 O(n)，节省空间复杂度到 O(1)
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
