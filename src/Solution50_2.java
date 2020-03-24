public class Solution50_2 {
    /**
     * 快速幂问题
     * 利用指数 n 的二进制数，时间 O(logn)，空间 O(1)
     * 注意：n有可能为负数或者 MIN_VALUE
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Pow(x, n).
     * Memory Usage: 37.1 MB, less than 5.88% of Java online submissions for Pow(x, n).
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        double base = x;
        double ans = 1;
        boolean isNegative = false;
        boolean isMin = false;
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                n++;
                isMin = true;
            }
            n = -n;
            isNegative = true;
        }
        while (n != 0) {
            if ((n & 1) == 1) {
                ans *= base;
            }
            base *= base;
            n >>= 1;
        }
        if (isMin) ans *= x;
        return isNegative ? 1 / ans : ans;
    }
}
