public class Solution58_2 {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Length of Last Word.
     * Memory Usage: 35.6 MB, less than 100.00% of Java online submissions for Length of Last Word.
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        int len = s.length();
        boolean isStart = false;
        int count = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ' && !isStart) isStart = true;
            if (s.charAt(i) == ' ' && isStart) return count;
            if (isStart) count++;
        }
        return count;
    }
}
