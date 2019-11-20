import java.util.Arrays;

public class Solution300_2 {
    /**
     * 巨秀无比的方法，类似贪心，O(nlogn)
     * Runtime: 1 ms, faster than 92.56% of Java online submissions for Longest Increasing Subsequence.
     * Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Longest Increasing Subsequence.
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return 1;
        int[] dp = new int[len];
        System.out.println(Arrays.toString(dp));
        int ans = 0;
        for (int num:nums) {
            int index = Arrays.binarySearch(dp, 0, ans, num);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = num;
            if (index == ans) ans++;
        }
        // System.out.println(Arrays.toString(dp));
        return ans;
    }

    public static void main(String[] args) {
        Solution300_2 solution300 = new Solution300_2();
        int[] nums = {1,3,6,7,9,4,10,5,6};
        solution300.lengthOfLIS(nums);
    }
}
