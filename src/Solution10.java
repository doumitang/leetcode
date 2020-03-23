public class Solution10 {

    /**
     * 正则表达式匹配问题
     * 可以很容易从这样的递归写法中看出，存在重叠子问题，因此可改写为dp保存中间结果
     * Runtime: 9 ms, faster than 35.85% of Java online submissions for Regular Expression Matching.
     * Memory Usage: 36.4 MB, less than 100.00% of Java online submissions for Regular Expression Matching.
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();
        return isMatchCore(sArray, 0, pArray, 0);
    }

    private boolean isMatchCore(char[] sArray, int sIndex, char[] pArray, int pIndex) {
        if (pIndex == pArray.length) return sIndex == sArray.length;
        boolean firstMatch = sIndex < sArray.length && (sArray[sIndex] == pArray[pIndex] || pArray[pIndex] == '.');
        // 后面是'*'，要么表示0个，要么表示多个。表示0个的话，pIndex直接加2，表示多个则需要匹配当前的字符
        if (pIndex + 1 < pArray.length && pArray[pIndex + 1] == '*') {
            return isMatchCore(sArray, sIndex, pArray, pIndex + 2) ||
                    firstMatch && isMatchCore(sArray, sIndex + 1, pArray, pIndex);
        } else {
            // 后面不是'*'，则需要匹配当前字符和之后的状态
            return firstMatch && isMatchCore(sArray, sIndex + 1, pArray, pIndex + 1);
        }
    }

    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();
        System.out.println(solution10.isMatch("ab", ".*c"));
    }

}
