public class Interview62 {
    /**
     * visit 数组模拟法，超时
     * 时间 O(n * m)
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        boolean[] visit = new boolean[n];
        int pos = -1;
        for (int i = 0; i < n; i++) {
            int k = 0;
            while (k < m) {
                pos = (pos + 1) % n;
                if (!visit[pos]) k++;
            }
            visit[pos] = true;
        }
        return pos;
    }

    public static void main(String[] args) {
        Interview62 interview62 = new Interview62();
        interview62.lastRemaining(5, 2);
    }
}
