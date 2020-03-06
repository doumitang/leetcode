import java.util.HashMap;
import java.util.Map;

public class Solution560_3 {
    /**
     * 也是累加和原理，但是实在是太秀了
     * 用 map 存上累加和为 sum 的次数，过程中查看是否存在 sum - k 的累加和
     * 如果存在，则把其次数加起来
     * 时间 O(n)，空间 O(n)
     * Runtime: 13 ms, faster than 60.92% of Java online submissions for Subarray Sum Equals K.
     * Memory Usage: 42.5 MB, less than 5.43% of Java online submissions for Subarray Sum Equals K.
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            ans += map.getOrDefault(sum - k, 0);
        }
        return ans;
    }
}
