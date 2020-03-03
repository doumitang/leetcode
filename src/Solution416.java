public class Solution416 {
    /**
     * 关键在于把问题转化成可以 01背包的 dp 问题上
     * 还有就是需要注意每个数只能用一次，要用到倒序遍历
     * 时间 O(VN)，空间 O(V)
     * Runtime: 5 ms, faster than 85.12% of Java online submissions for Partition Equal Subset Sum.
     * Memory Usage: 37.8 MB, less than 50.79% of Java online submissions for Partition Equal Subset Sum.
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            // 倒序遍历的原因是因为每个数只能用一次
            for (int j = target; j - nums[i] >= 0; j--) {
                if (dp[j - nums[i]]) dp[j] = true;
            }
            if (dp[target]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution416 solution416 = new Solution416();
        System.out.println(solution416.canPartition(new int[]{1,2,5}));
    }
}
