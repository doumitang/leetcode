import java.util.Arrays;

public class Solution494_2 {
    private int[][] mem = null;

    /**
     * 刚刚递归回溯的改进版，用 mem 缓存重复的递归结果
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;
        mem = new int[nums.length][2001]; // 题目说所有数的和不会超过1000
        for (int[] ints : mem) {
            Arrays.fill(ints, Integer.MIN_VALUE);

        }
        return backTrack(nums, 0, 0, S);
    }

    private int backTrack(int[] sums, int pos, int sum, int target) {
        if (pos == sums.length) {
            if (sum == target) return 1; // 表明走通了一条路
            else return 0;
        }
        if (mem[pos][sum + 1000] != Integer.MIN_VALUE) return mem[pos][sum + 1000];
        // 分别计算往正向走的路数和负向走的路数
        int positive = backTrack(sums, pos + 1, sum + sums[pos], target);
        int negative = backTrack(sums, pos + 1, sum - sums[pos], target);
        mem[pos][sum + 1000] = positive + negative;
        return mem[pos][sum + 1000];
    }

    public static void main(String[] args) {
        Solution494_2 solution494 = new Solution494_2();
        System.out.println(solution494.findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }
}
