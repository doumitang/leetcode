public class Solution204 {
    /**
     * 质数计数问题（厄拉多塞筛法）
     * 筛除素数的所有倍数，剩下的就是素数
     * Runtime: 12 ms, faster than 65.96% of Java online submissions for Count Primes.
     * Memory Usage: 41.3 MB, less than 5.66% of Java online submissions for Count Primes.
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        int ans = 0;
        boolean[] notPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                ans++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true; // true 表示不是质数，排除的
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution204 solution204 = new Solution204();
        System.out.println(solution204.countPrimes(10));
    }
}
