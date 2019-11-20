import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution39_2 {
    /**
     * 回溯法，遇到不通的路不再往后走，因为已经进行了排序
     * 一直复制list对象会耗费时间，最后复制返回即可，中途回溯删除最后一个元素
     * Runtime: 2 ms, faster than 99.81% of Java online submissions for Combination Sum.
     * Memory Usage: 37.6 MB, less than 100.00% of Java online submissions for Combination Sum.
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> comb = new ArrayList<>();
        backtrack(ans, comb, 0, candidates, target);
        return ans;
    }

    private boolean backtrack(List<List<Integer>> ans, List<Integer> comb, int index, int[] candidates, int target) {
//        System.out.println(comb);
//        System.out.println(target);
        if (target == 0) {
            ans.add(new ArrayList<>(comb));
            return false;
        }
        if (target < 0) return false;
        for (int i = index; i < candidates.length; i++) {
            int candidate = candidates[i];
            comb.add(candidate);
            boolean flag = backtrack(ans, comb, i, candidates, target - candidate);
            comb.remove(comb.size() - 1);
            if (!flag) break;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution39_2 solution39_2 = new Solution39_2();
        int[] candidates = {2,3,6,7};
        System.out.println(solution39_2.combinationSum(candidates, 7));
    }
}