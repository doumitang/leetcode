import java.util.ArrayList;
import java.util.List;

public class Solution438_2 {
    /**
     * 双指针滑动窗口，关键在于记录 p 中每个字符的个数，以及 s 中还需要的字符个数 need
     * Runtime: 4 ms, faster than 99.17% of Java online submissions for Find All Anagrams in a String.
     * Memory Usage: 41.3 MB, less than 6.00% of Java online submissions for Find All Anagrams in a String.
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
        // 记录 p 中每个字符的个数
        int[] pCounter = new int[26];
        for (char c : pArray) {
            pCounter[c - 'a']++;
        }
        int need = pArray.length;
        int left = 0, right = 0; // 初始化窗口长度为 0
        while (right < sArray.length) {
            pCounter[sArray[right] - 'a']--;
            if (pCounter[sArray[right] - 'a'] >= 0) {
                need--;
            }
            right++; // 把 right 位置的字符移入窗口
            if (need == 0) ans.add(left);
            // 把 left 位置的字符移出窗口
            if (right - left == pArray.length) {
                pCounter[sArray[left] - 'a']++;
                if (pCounter[sArray[left] - 'a'] > 0) {
                    need++;
                }
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution438_2 solution438_2 = new Solution438_2();
        System.out.println(solution438_2.findAnagrams("cbaebabacd","abc"));
    }
}
