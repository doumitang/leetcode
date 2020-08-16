public class Solution397 {

    /**
     * 最先想到的就是二进制解法，除以 2 为右移操作
     * 尾数是 0 只需一步操作，而尾数是 1 的话考虑 -1 还是 +1
     * 如果 -1 是稳定消除一个 1，而 +1 只有在尾数是 11 才能消除一个 1 变成 100
     * @param n
     * @return
     */
    public int integerReplacement(int n) {
        if (n == Integer.MAX_VALUE) return 32;
        if (n == 1) return 0;
        // 尾数是 0
        if ((n & 1) == 0) {
            return 1 + integerReplacement(n >> 1);
        }
        // 尾数是 1，但倒数第二位是 0，或者 n == 3
        if ((n & 2) == 0 || n == 3) {
            return 1 + integerReplacement(n - 1);
        }
        return 1 + integerReplacement(n + 1);
    }

    public static void main(String[] args) {
        Solution397 solution397 = new Solution397();
        solution397.integerReplacement(2147483647);
    }
}
