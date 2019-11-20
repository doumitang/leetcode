import java.util.Arrays;

public class Solution96 {
    public int numTrees(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = i - 1; j >= 0; j--){
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
//        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public static void main(String[] args) {
        Solution96 solution96 = new Solution96();
        System.out.println(solution96.numTrees(4));
    }
}
