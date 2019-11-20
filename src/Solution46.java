import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length == 0) return ans;
        List<Integer> element = new ArrayList<>();
        Set<Integer> selected = new HashSet<>();
        recursion(ans, nums, element, selected);
        return ans;
    }

    private void recursion(List<List<Integer>> ans, int[] nums, List<Integer> element, Set<Integer> selected) {
        System.out.println(element);
        if (selected.size() == nums.length) {
            ans.add(element);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (selected.contains(i)) continue;
            List<Integer> elementCp = new ArrayList<>(element);
            Set<Integer> selectedCp = new HashSet<>(selected);
            elementCp.add(nums[i]);
            selectedCp.add(i);
            recursion(ans, nums, elementCp, selectedCp);
        }
    }

    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
        int[] nums = {1,2,3};
        System.out.println(solution46.permute(nums));
    }
}