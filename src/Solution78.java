import java.util.ArrayList;
import java.util.List;

public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        recursion(ans, nums, temp, 0);
        return ans;
    }

    private void recursion(List<List<Integer>> ans, int[] nums, List<Integer> temp, int index) {
        if (index == nums.length) {
            ans.add(temp);
            return;
        }
        List<Integer> temp_cp0 = new ArrayList<>(temp);
        recursion(ans, nums, temp_cp0, index + 1);
        List<Integer> temp_cp1 = new ArrayList<>(temp);
        temp_cp1.add(nums[index]);
        recursion(ans, nums, temp_cp1, index + 1);
    }
}
