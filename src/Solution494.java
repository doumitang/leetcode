public class Solution494 {
    private int ans = 0;

    /**
     * 递归实现的回溯法，本质为暴力法，时间 O(l * n) l为和的范围，空间 O(n)递归深度
     * Runtime: 11 ms, faster than 66.36% of Java online submissions for Target Sum.
     * Memory Usage: 41.9 MB, less than 6.00% of Java online submissions for Target Sum.
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;
        backTrack(nums, 0, 0, S);
        return ans;
    }

    private void backTrack(int[] sums, int pos, int sum, int target) {
        if (pos == sums.length) {
            if (sum == target) ans++;
            return;
        }
        backTrack(sums, pos + 1, sum + sums[pos], target);
        backTrack(sums, pos + 1, sum - sums[pos], target);
    }

    public static void main(String[] args) {
        Solution494 solution494 = new Solution494();
        System.out.println(solution494.findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }
}
