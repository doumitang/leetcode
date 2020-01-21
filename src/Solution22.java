import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    private List<String> ans = new ArrayList<>();
    private StringBuilder stringBuilder = new StringBuilder();

    /**
     * 生成所有合法的括号组合
     * Runtime: 1 ms, faster than 96.06% of Java online submissions for Generate Parentheses.
     * Memory Usage: 39.4 MB, less than 20.64% of Java online submissions for Generate Parentheses.
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        recursion(0, 0, n);
        return ans;
    }

    private void recursion(int leftNum, int rightNum, int n) {
        if (stringBuilder.length() == 2 * n) {
            ans.add(stringBuilder.toString());
        }
        if (leftNum < n) {
            stringBuilder.append('(');
            recursion(leftNum + 1, rightNum, n);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if (rightNum < leftNum) {
            stringBuilder.append(')');
            recursion(leftNum, rightNum + 1, n);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
