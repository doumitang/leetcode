public class Solution29_2 {
    /**
     * 改进上一种想法，每次找到这样一个temp，它是 divisor 的 2 ^ k 倍，正好小于等于 dividend
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Divide Two Integers.
     * Memory Usage: 37.1 MB, less than 6.06% of Java online submissions for Divide Two Integers.
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        boolean isDef = dividend < 0 ^ divisor < 0; // 用异或判断是否异号
        long a = dividend > 0 ? -dividend : dividend;
        long b = divisor > 0 ? -divisor : divisor;
        int ans = 0;
        long temp = b, count = -1;
        while (a <= b) {
            temp = b;
            count = -1;
            while ((temp << 1) >= a) {
                temp <<= 1;
                count <<= 1;
            }
            a -= temp;
            ans += count;
        }
        if (ans < -Integer.MAX_VALUE && !isDef) return Integer.MAX_VALUE;
        return isDef ? ans : -ans;
    }

    public static void main(String[] args) {
        Solution29_2 solution29_2 = new Solution29_2();
        System.out.println(solution29_2.divide(10, 3));
    }
}
