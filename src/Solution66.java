import java.util.Arrays;

public class Solution66 {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Plus One.
     * Memory Usage: 35.3 MB, less than 97.58% of Java online submissions for Plus One.
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int carry = 1, tempRes = 0, len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            tempRes = digits[i] + carry;
            digits[i] = tempRes % 10;
            carry = tempRes / 10;
        }
        int[] ans;
        if (carry > 0) {
            ans = new int[len + 1];
            ans[0] = carry;
            for (int i = 0; i < len - 1; i++) {
                ans[i + 1] = digits[i];
            }
        } else {
            ans = digits;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution66 solution66 = new Solution66();
        System.out.println(Arrays.toString(solution66.plusOne(new int[]{9})));
    }
}
