public class Solution53_2 {
    // 分治，听说更微妙？
    public int maxSubArray(int[] nums) {
        int ans = 0;
        if (nums.length == 0) return ans;
        return recursion(nums, 0, nums.length - 1);
    }

    private int recursion(int[] nums, int low, int high) {
//        System.out.println("" + low + " " + high);
        if (low == high) return nums[low];
        if (low > high) return Integer.MIN_VALUE;
        int mid = (low + high) / 2;
        int maxLow = recursion(nums, low, mid);
        int maxHigh = recursion(nums, mid + 1, high);
        // 合并
        int maxMidLow = Integer.MIN_VALUE, maxMidHigh = Integer.MIN_VALUE, tempMidLow = 0, tempMidHigh = 0;
        for (int i = mid; i >= low; i--) {
            tempMidLow += nums[i];
            maxMidLow = Math.max(maxMidLow, tempMidLow);
        }
        for (int i = mid + 1; i <= high; i++) {
            tempMidHigh += nums[i];
            maxMidHigh = Math.max(maxMidHigh, tempMidHigh);
        }
        int maxMid = maxMidLow + maxMidHigh;
        return Math.max(maxMid, Math.max(maxLow, maxHigh));
    }

    public static void main(String[] args) {
        Solution53_2 solution53_2 = new Solution53_2();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solution53_2.maxSubArray(nums));
    }
}
