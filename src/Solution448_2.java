import java.util.ArrayList;
import java.util.List;

public class Solution448_2 {
    /**
     * 空间复杂度O(1)
     * 精髓：取相反数，保证原数据不丢失
     * Runtime: 6 ms, faster than 80.09% of Java online submissions for Find All Numbers Disappeared in an Array.
     * Memory Usage: 47.9 MB, less than 75.47% of Java online submissions for Find All Numbers Disappeared in an Array.
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int num:nums) {
            int pos = Math.abs(num) - 1;
            if (nums[pos] > 0) {
                nums[pos] = -nums[pos];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
