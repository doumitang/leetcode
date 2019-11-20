import java.util.HashMap;
import java.util.Map;

public class Solution169 {
    /**
     * Runtime: 13 ms, faster than 32.73% of Java online submissions for Majority Element.
     * Memory Usage: 38.9 MB, less than 93.97% of Java online submissions for Majority Element.
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int ans = 0, len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : nums) {
            int count = 1;
            if (map.containsKey(val)) count = map.get(val) + 1;
            if (count > len / 2) return val;
            map.put(val, count);
        }
        return ans;
    }
}
