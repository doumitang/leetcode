import java.util.*;

public class Solution139 {

    private Map<String, Boolean> dp = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.isEmpty()) return true;
        for (String str : wordDict) {
            if (s.startsWith(str)) {
                String subStr = s.substring(str.length());
                if (!dp.containsKey(subStr)) {
                    boolean b = wordBreak(subStr, wordDict);
                    dp.put(subStr, b);
                    if (b) return true;
                } else if (dp.get(subStr)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution139 solution139 = new Solution139();
        String s1 = "leetcode";
        List<String> wordDict1 = new ArrayList<>();
        wordDict1.add("leet");
        wordDict1.add("code");
        String s2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> wordDict2 = new ArrayList<>();
        wordDict2.add("a");
        wordDict2.add("aaaaaaaaa");
        wordDict2.add("aaaaaaaaaaaaaaaaaaaaa");
        solution139.wordBreak(s2, wordDict2);
    }
}
