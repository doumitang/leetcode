import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution18 {
    /**
     * 参考15题，先排序，再用双指针，时间O(nlogn + n^3)
     * Runtime: 19 ms, faster than 72.11% of Java online submissions for 4Sum.
     * Memory Usage: 37.1 MB, less than 100.00% of Java online submissions for 4Sum.
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4) return ans;
        Arrays.sort(nums);
        int len = nums.length;
        for (int p = 0; p < len; p++) {
            if (p > 0 && nums[p] == nums[p - 1]) continue;
            for (int k = p + 1; k < len; k++) {
                if (k > p + 1 && nums[k] == nums[k - 1]) continue;
                int i = k + 1, j = len - 1;
                while (i < j) {
                    if (nums[p] + nums[i] + nums[j] + nums[k] == target) {
                        // 相比于先声明一个临时List，一个一个加入，然后clear掉，这样写更快
                        ans.add(Arrays.asList(nums[p], nums[k], nums[i], nums[j]));
                        i++;
                        j--;
                        while (i < j && nums[i] == nums[i - 1]) i++;
                        while (i < j && nums[j] == nums[j + 1]) j--;
                    } else if (nums[p] + nums[i] + nums[j] + nums[k] < target) {
                        i++;
                    } else {
                        j--;
                    }
                }
            }
        }
        return ans;
    }
}
