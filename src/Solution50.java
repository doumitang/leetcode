public class Solution50 {
    /**
     * 分治法 + 减少重复计算 == 动态规划
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Pow(x, n).
     * Memory Usage: 33.7 MB, less than 5.88% of Java online submissions for Pow(x, n).
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == Integer.MIN_VALUE) {
            n++;
            return 1 / (recursion(x, -n) * x);
        }
        return n > 0 ? recursion(x, n) : 1 / recursion(x, -n);
    }

    private double recursion(double x, int n) {
        if (n == 1) return x;
        double temp = myPow(x, n / 2);
        return  n % 2 == 0 ? temp * temp : temp * temp * x;
    }

    public static void main(String[] args) {
        Solution50 solution50 = new Solution50();
        solution50.myPow(1, Integer.MIN_VALUE);
    }
}
