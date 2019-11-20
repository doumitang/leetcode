import java.util.Arrays;

public class Solution287_2 {
    public int findDuplicate(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                ans = nums[i];
                break;
            }
        }
        return ans;
    }
}
