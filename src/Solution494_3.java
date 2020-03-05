public class Solution494_3 {

    /**
     * dp，关键在于转化问题话 01背包问题
     * target = sum(P) - sum(N)
     * sum(nums) = sum(P) + sum(N)
     * 所以有 target + sum(nums) = 2 * sum(P)
     * sum(P) = (target + sum(nums)) / 2
     * 也就是说要找到这样几个物品，他们的和等于右边的数值，求这样的挑选有多少种
     * 时间 O(VN)，空间 O(V)，其中 V = (target + sum(nums)) / 2
     * Runtime: 2 ms, faster than 93.62% of Java online submissions for Target Sum.
     * Memory Usage: 37.6 MB, less than 26.00% of Java online submissions for Target Sum.
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 因为创建的 dp 数组的大小和 S 有关，不判断 sum < S 会报超过内存的错误 Memory Limit Exceeded
        if (sum < S || ((S + sum) & 1) == 1) return 0;
        S = (S + sum) / 2;
        int[] dp = new int[S + 1];
        dp[0] = 1; // 对于第 0 个物品来说，使得容量为 0 只有 1 种
        for (int i = 0; i < nums.length; i++) {
            for (int j = dp.length - 1; j - nums[i] >= 0; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[S];
    }


    public static void main(String[] args) {
        Solution494_3 solution494 = new Solution494_3();
        System.out.println(solution494.findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }
}
