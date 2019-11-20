public class Solution169_2 {
    // 投票算法，时间复杂度O(n)，空间复杂度O(1)
    public int majorityElement(int[] nums) {
        int vote = 0, candidate = 0;
        for (int val:nums) {
            if (vote == 0) candidate = val;
            vote += (candidate == val ? 1 : -1);
        }
        return candidate;
    }
}
