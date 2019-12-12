public class Solution9_2 {
    /**
     * 把x的数位从后往前存到rev，时间复杂度快一半
     * Runtime: 6 ms, faster than 100.00% of Java online submissions for Palindrome Number.
     * Memory Usage: 36 MB, less than 5.02% of Java online submissions for Palindrome Number.
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return x == rev || x == rev / 10;
    }
}
