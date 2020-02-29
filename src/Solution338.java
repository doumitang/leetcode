public class Solution338 {
    /**
     * 最直观的想法，时间O(n * sizeof(integer))
     * Runtime: 4 ms, faster than 19.87% of Java online submissions for Counting Bits.
     * Memory Usage: 43.6 MB, less than 5.88% of Java online submissions for Counting Bits.
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int temp = 0, val = i;
            while (val != 0) {
                if ((val & 1) == 1) temp++;
                val >>>= 1;
            }
            ans[i] = temp;
        }
        return ans;
    }
}
