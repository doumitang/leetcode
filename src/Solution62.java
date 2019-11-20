public class Solution62 {
    public int uniquePaths(int m, int n) {
//        System.out.println(Integer.MAX_VALUE);
        int ans = 1;
        int stepRight = m - 1, stepDown = n - 1;
        if (stepRight < 1 || stepDown < 1) return ans;
        int sumStep = stepRight + stepDown, minStep = Math.min(stepRight, stepDown);
        long numerator = 1, denominator = 1; // 组合的分子和分母
        for (int i = 0; i < minStep; i++) {
//            System.out.println(sumStep);
            numerator *= sumStep;
            sumStep--;
        }
//        System.out.println(numerator);
//        System.out.println("--------------------------------------------");
        while (minStep >= 1) {
//            System.out.println(minStep);
            denominator *= minStep;
            minStep--;
        }
//        System.out.println(denominator);
        ans = (int) (numerator / denominator);
        return ans;
    }

    public static void main(String[] args) {
        Solution62 solution62 = new Solution62();
        System.out.println(solution62.uniquePaths(10, 10));
    }
}
