public class Solution10_2 {

    enum Result {
        TRUE, FALSE;
    }

    private Result[][] memo;

    /**
     * 自顶向下的dp（备忘录法），缓存递归的中间结果
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Regular Expression Matching.
     * Memory Usage: 36.8 MB, less than 100.00% of Java online submissions for Regular Expression Matching.
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();
        memo = new Result[sArray.length + 1][pArray.length + 1];
        return isMatchCore(sArray, 0, pArray, 0);
    }

    private boolean isMatchCore(char[] sArray, int sIndex, char[] pArray, int pIndex) {
        if (memo[sIndex][pIndex] != null) return memo[sIndex][pIndex] == Result.TRUE;
        boolean ans;
        if (pIndex == pArray.length) {
            ans = sIndex == sArray.length;
        } else {
            boolean firstMatch = sIndex < sArray.length && (sArray[sIndex] == pArray[pIndex] || pArray[pIndex] == '.');
            if (pIndex + 1 < pArray.length && pArray[pIndex + 1] == '*') {
                ans = isMatchCore(sArray, sIndex, pArray, pIndex + 2) ||
                        firstMatch && isMatchCore(sArray, sIndex + 1, pArray, pIndex);
            } else {
                ans = firstMatch && isMatchCore(sArray, sIndex + 1, pArray, pIndex + 1);
            }
        }
        memo[sIndex][pIndex] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }
}
