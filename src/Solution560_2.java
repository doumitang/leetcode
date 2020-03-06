public class Solution560_2 {
    /**
     * 这题的想法居然是改进暴力法，我麻了
     * 采用累加和原理，使得时间从 O(n ^ 3) 改进到 O(n ^ 2)，空间 O(1)
     * Runtime: 213 ms, faster than 12.52% of Java online submissions for Subarray Sum Equals K.
     * Memory Usage: 41 MB, less than 8.69% of Java online submissions for Subarray Sum Equals K.
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) ans++;
            }
        }
        return ans;
    }
}
