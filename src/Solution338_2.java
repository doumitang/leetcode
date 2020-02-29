public class Solution338_2 {
    /**
     * i - 1是把 i 的最后一个 1 和 其后面的所有 0 取反，因此 i & (i - 1) 可以消除 i 的最后一个 1，使得 1 的数量少 1
     * Runtime: 1 ms, faster than 99.55% of Java online submissions for Counting Bits.
     * Memory Usage: 43.3 MB, less than 5.88% of Java online submissions for Counting Bits.
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            ans[i] = ans[i & (i - 1)] + 1;
        }
        return ans;
    }
}
