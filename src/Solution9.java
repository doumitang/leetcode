public class Solution9 {
    /**
     * 借鉴Solution7倒转整数，但不是最优
     * Runtime: 7 ms, faster than 73.68% of Java online submissions for Palindrome Number.
     * Memory Usage: 35.6 MB, less than 7.82% of Java online submissions for Palindrome Number.
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int temp = x, ans = 0;
        while (temp != 0) {
            int y = temp % 10;
            if (ans > (Integer.MAX_VALUE - y) / 10) return false;
            ans = ans * 10 + y;
            temp /= 10;
        }
        return x == ans;
    }
}
