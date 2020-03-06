public class Solution560 {
    /**
     * 自己想到的 dp 解法，但是内存超了 Memory Limit Exceeded
     * 设 f(i, j)表示容量为 j，以第 i 个物品为结尾的子串个数
     * 两种情况，第 i 个物品要么连着前面，要么以自己为开头
     * f(i, j) = f(i - 1, j - nums[j]) + (nums[j] == j ? 1 : 0)
     * 时间 O(n * (sumPositive + offset + 1))，空间一样
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int sumPositive = 0, sumNegative = 0;
        for (int num : nums) {
            if (num > 0) sumPositive += num;
            else sumNegative += num;
        }
        if (k > sumPositive) return 0;
        if (k < sumNegative) return 0;
        int offset = -sumNegative;
        int[][] dp = new int[nums.length][sumPositive + offset + 1];
        int ans[] = new int[sumPositive + offset + 1];
        dp[0][0 + offset] = 0;
        if (nums[0] + offset < sumPositive + offset + 1) {
            dp[0][nums[0] + offset] = 1;
            ans[nums[0] + offset] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < sumPositive + offset + 1; j++) {
                int sub = j - nums[i];
                if (sub >= 0 && sub < sumPositive + offset + 1) {
                    dp[i][j] = dp[i - 1][sub];
                }
                dp[i][j] += (nums[i] == j - offset ? 1 : 0);
                ans[j] += dp[i][j];
            }
        }
        return ans[k + offset];
    }

    public static void main(String[] args) {
        Solution560 solution560 = new Solution560();
        System.out.println(solution560.subarraySum(new int[]{0,0,0,0,0,0,0,0,0,0},
                0));
    }
}
