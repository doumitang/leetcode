import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution438 {
    /**
     * 我的直观想法，假设 p 的长度为 k，先把 p 排序，然后遍历 s 每次取 k 个字符出来排序，再和 p 比较
     * 时间 O(n * k logk)，空间 O(k)
     * Runtime: 1630 ms, faster than 5.02% of Java online submissions for Find All Anagrams in a String.
     * Memory Usage: 42.8 MB, less than 6.00% of Java online submissions for Find All Anagrams in a String.
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || p == null) return ans;
        if (s.length() < p.length()) return ans;
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();
        Arrays.sort(pArray);
        char[] temp = new char[pArray.length];
        for (int i = 0; i <= sArray.length - pArray.length; i++) {
            int index = i;
            for (int j = 0; j < temp.length; j++, index++) {
                temp[j] = sArray[index];
            }
            Arrays.sort(temp);
            boolean flag = true;
            for (int j = 0; j < temp.length; j++) {
                if (temp[j] != pArray[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans.add(i);
            }
        }
        return ans;
    }
}
