public class Solution7 {
    /**
     * 利用负数阈值做统一判断
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Reverse Integer.
     * Memory Usage: 33.4 MB, less than 11.66% of Java online submissions for Reverse Integer.
     * @param x
     * @return
     */
    public int reverse(int x) {
        boolean flag = x < 0;
        if (!flag) x = -x;
        int ans = 0;
        while (x != 0) {
            int y = x % 10;
            if (ans < (Integer.MIN_VALUE - y) / 10) return 0;
            ans = ans * 10 + y;
            x = x / 10;
        }
        if (!flag && ans < -Integer.MAX_VALUE) return 0;
        return flag ? ans : -ans;
    }

    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        int ans = solution7.reverse(1463847412);
        System.out.println(ans);
    }
}
