public class Solution739 {
    /**
     * 最直观的实现，时间 O(n ^ 2)，空间 O(1)
     * Runtime: 920 ms, faster than 5.03% of Java online submissions for Daily Temperatures.
     * Memory Usage: 43.1 MB, less than 84.75% of Java online submissions for Daily Temperatures.
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) return null;
        int[] ans = new int[T.length];
        for (int i = 0; i < ans.length; i++) {
            for (int j = i + 1; j < ans.length; j++) {
                if (T[j] > T[i]) {
                    ans[i] = j - i;
                    break;
                }
            }
        }
        return ans;
    }
}
