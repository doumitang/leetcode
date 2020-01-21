import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution17_2 {
    private Map<Character, String> map = new HashMap<>();

    private List<String> ans = new ArrayList<>();

    private StringBuilder str = new StringBuilder();

    public Solution17_2() {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    /**
     * 把刚刚的改成递归回溯写法
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Letter Combinations of a Phone Number.
     * Memory Usage: 35.8 MB, less than 98.63% of Java online submissions for Letter Combinations of a Phone Number.
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return ans;
        letterCombinationsCore(digits, 0);
        return ans;
    }

    private void letterCombinationsCore(String digits, int pos) {
        if (pos == digits.length()) {
            ans.add(str.toString());
            return;
        }
        String temp = map.getOrDefault(digits.charAt(pos), null);
        if (temp != null) {
            for (int i = 0; i < temp.length(); i++) {
                str.append(temp.charAt(i));
                letterCombinationsCore(digits, pos + 1);
                str.deleteCharAt(str.length() - 1);
            }
        }
    }
}
