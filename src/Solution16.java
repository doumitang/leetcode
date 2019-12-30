import java.util.Arrays;

public class Solution16 {
    /**
     * 参考Solution15
     * Runtime: 4 ms, faster than 95.25% of Java online submissions for 3Sum Closest.
     * Memory Usage: 36.3 MB, less than 100.00% of Java online submissions for 3Sum Closest.
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length, ans = target + 100000;
        for (int k = 0; k < len; k++) {
            int i = k + 1, j = len - 1;
            while (i < j) {
                int sum = nums[i] + nums[j] + nums[k];
//                System.out.println(Arrays.asList(nums[k], nums[i], nums[j], sum, ans - target, Math.abs(sum - target), Math.abs(ans - target)));
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        int[] nums = {1,1,1,1};
        System.out.println(solution16.threeSumClosest(nums, -100));
    }
}
