import java.util.ArrayList;
import java.util.List;

public class Solution46_2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length == 0) return ans;
        List<Integer> element = new ArrayList<>();
        insertVal(ans, nums, element, 0);
        return ans;
    }

    private void insertVal(List<List<Integer>> ans, int[] nums, List<Integer> element, int index) {
        if (index == nums.length) {
            ans.add(element);
            return;
        }
        for (int i = 0; i < element.size() + 1; i++) {
            List<Integer> elementCp = new ArrayList<>(element);
            elementCp.add(i, nums[index]);
            insertVal(ans, nums, elementCp, index + 1);
        }
    }
}
