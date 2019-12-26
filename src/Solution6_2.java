public class Solution6_2 {
    /**
     * 跟上一种方法本质一样，但是这个是按照之字形状来分析的，更清楚
     * For all whole numbers k,
     * Characters in row 0 are located at indexes k(2⋅numRows−2) + 0
     * Characters in inner row i are located at indexes k(2⋅numRows−2) + i and (k+1)(2⋅numRows−2) − i.
     * Characters in row numRows−1 are located at indexes k(2⋅numRows−2) + (numRows−1)
     *
     * Runtime: 3 ms, faster than 96.48% of Java online submissions for ZigZag Conversion.
     * Memory Usage: 38.3 MB, less than 88.30% of Java online submissions for ZigZag Conversion.
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
}
