public class Solution29 {
    /**
     * 超时：直观的想法，一直加上去
     * Time Limit Exceeded
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        boolean isDef = false;
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
            isDef = true;
        }
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;
        int ans = 0, sum = 0;
        while (sum > dividend) {
            sum += divisor;
            ans--;
        }
        if (sum < dividend) ans++;
        if (ans == Integer.MIN_VALUE && !isDef) return Integer.MAX_VALUE;
        return isDef ? ans : -ans;
    }

    public static void main(String[] args) {
        Solution29 solution29 = new Solution29();
        System.out.println(solution29.divide(-1, -1));
    }
}
