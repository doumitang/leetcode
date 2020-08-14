public class Solution125 {
    /**
     * Runtime: 4 ms, faster than 56.45% of Java online submissions for Valid Palindrome.
     * Memory Usage: 40.6 MB, less than 20.64% of Java online submissions for Valid Palindrome.
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int i = 0, j = s.length() - 1;
        boolean ans = true;
        char left = 0, right = 0;
        while (i < j) {
            while (i < s.length() && !isValid(s.charAt(i))) {
                i++;
            }
            while (j >= 0 && !isValid(s.charAt(j))) {
                j--;
            }
            if (i >= s.length() && j < 0) return true;
            if (i < s.length() && j >= 0) {
                left = getCharacter(s, i++);
                right = getCharacter(s, j--);
                if (left != right) return false;
                continue;
            }
            return false;
        }
        return true;
    }

    private char getCharacter(String s, int i) {
        if (isUpperCase(s.charAt(i))) {
            return (char) (s.charAt(i) + 32);
        }
        return s.charAt(i);
    }

    private boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private boolean isValid(char c) {
        return c >= '0' && c <= '9' || c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z';
    }

    public static void main(String[] args) {
        Solution125 solution125 = new Solution125();
        System.out.println(solution125.isPalindrome(
                "A man, a plan, a canal: Panama"));
    }
}
