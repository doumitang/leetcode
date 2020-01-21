import java.util.ArrayList;
import java.util.List;

public class Solution6 {
    /**
     * 第一轮加入相当于分区，然后把每个分区内部的两头加入
     * Runtime: 4 ms, faster than 79.92% of Java online submissions for ZigZag Conversion.
     * Memory Usage: 39 MB, less than 75.53% of Java online submissions for ZigZag Conversion.
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        int len = s.length(), mod = 2 * numRows - 2;
        char[] arr = s.toCharArray();
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < len; i = i + mod) {
            index.add(i);
        }
        StringBuilder ans = new StringBuilder();
        for (Integer pos : index) {
            ans.append(arr[pos]);
        }
        int delta = 1;
        mod -= 2;
        while (mod >= 0) {
            for (Integer pos : index) {
                if (pos + delta < len) ans.append(arr[pos + delta]);
                if (mod > 0 && pos + delta + mod < len) ans.append(arr[pos + delta + mod]);
            }
            delta++;
            mod -= 2;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        System.out.println(solution6.convert("A", 1));
    }
}
