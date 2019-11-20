import java.util.ArrayList;
import java.util.List;

public class Solution448 {
    /**
     * 空间复杂度O(n)
     * Runtime: 5 ms, faster than 90.20% of Java online submissions for Find All Numbers Disappeared in an Array.
     * Memory Usage: 47.1 MB, less than 94.34% of Java online submissions for Find All Numbers Disappeared in an Array.
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = i + 1;
        }
        for (int num:nums) {
            ans[num - 1] = 0;
        }
        List<Integer> list = new ArrayList<>();
        for (int val:ans) {
            if (val != 0) list.add(val);
        }
        return list;
    }
}
