import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
    /**
     * 先排序，再用双指针，时间O(nlogn + n^2)
     * Runtime: 31 ms, faster than 75.44% of Java online submissions for 3Sum.
     * Memory Usage: 48.1 MB, less than 82.68% of Java online submissions for 3Sum.
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) return ans;
        Arrays.sort(nums);
        int len = nums.length;
        for (int k = 0; k < len; k++) {
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = len - 1;
            while (i < j) {
                if (nums[i] + nums[j] == -nums[k]) {
                    // 相比于先声明一个临时List，一个一个加入，然后clear掉，这样写更快
                    ans.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    i++;
                    j--;
                    while (i < j && nums[i] == nums[i - 1]) i++;
                    while (i < j && nums[j] == nums[j + 1]) j--;
                } else if (nums[i] + nums[j] < -nums[k]) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        solution15.threeSum(nums);
    }
}
