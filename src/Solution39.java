import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution39 {
    // Runtime: 121 ms, faster than 5.06% of Java online submissions for Combination Sum.
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        recursion(ans, comb, 0, candidates, target);
        return ans;
    }

    private void recursion(List<List<Integer>> ans, List<Integer> comb, int sum, int[] candidates, int target) {
//        System.out.println(comb);
//        System.out.println(sum);
        if (sum == target) {
            comb.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            if (!ans.contains(comb)) {
                ans.add(comb);
            }
            return;
        }
        if (sum > target) return;
        for (int candidate : candidates) {
            List<Integer> comb_cp = new ArrayList<>(comb);
            int sum_cp = sum;
            comb_cp.add(candidate);
            sum_cp += candidate;
            recursion(ans, comb_cp, sum_cp, candidates, target);
        }
    }

    public static void main(String[] args) {
        Solution39 solution39 = new Solution39();
        int[] candidates = {2,3,6,7};
        System.out.println(solution39.combinationSum(candidates, 7));
    }
}