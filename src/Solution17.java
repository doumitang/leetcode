import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution17 {
    private Map<Character, String> map = new HashMap<>();

    public Solution17() {
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
     * dp思想，假设知道子问题的解，用当前的字符和子问题的解组合即可
     * Runtime: 1 ms, faster than 43.28% of Java online submissions for Letter Combinations of a Phone Number.
     * Memory Usage: 36.2 MB, less than 98.63% of Java online submissions for Letter Combinations of a Phone Number.
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) return ans;
        if (digits.length() == 1) {
            String temp = map.getOrDefault(digits.charAt(0), null);
            if (temp != null) {
                for (int i = 0; i < temp.length(); i++)
                    ans.add(String.valueOf(temp.charAt(i)));
            }
            return ans;
        }
        List<String> sub = letterCombinations(digits.substring(1));
        String temp = map.getOrDefault(digits.charAt(0), null);
        if (temp != null) {
            for (int i = 0; i < temp.length(); i++) {
                for (String s : sub) {
                    ans.add(temp.charAt(i) + s);
                }
            }
        }
        return ans;
    }
}
