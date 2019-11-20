public class Solution67 {
    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Add Binary.
     * Memory Usage: 36.2 MB, less than 100.00% of Java online submissions for Add Binary.
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int carry = 0, tempRes = 0;
        int indexA = a.length() - 1, indexB = b.length() - 1;
        while (indexA >= 0 || indexB >= 0) {
            int digitA = 0, digitB = 0;
            if (indexA >= 0) digitA = a.charAt(indexA) - '0';
            if (indexB >= 0) digitB = b.charAt(indexB) - '0';
            tempRes = digitA + digitB + carry;
            carry = tempRes / 2;
            char ch = (char) (tempRes % 2 + '0');
            ans.insert(0, ch);
            indexA--;
            indexB--;
        }
        if (carry > 0) {
            char ch = (char) (carry + '0');
            ans.insert(0, ch);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution67 solution67 = new Solution67();
        solution67.addBinary("11", "1");
    }
}
